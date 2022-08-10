package Farmacista;

import CredenzialiUtente.CredenzialiUtente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConfermaRicezioneOrdini extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public ConfermaRicezioneOrdini() throws ClassNotFoundException, SQLException {
        initComponents();
        mostra_check();
    }

    public ArrayList<CheckOrdiniDaConfermare> checkList() throws ClassNotFoundException, SQLException{
        ArrayList<CheckOrdiniDaConfermare> checksList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "pharmalinkazienda";
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "";
        try{
            Class.forName(driver);
            this.connessione = DriverManager.getConnection(url+dbName, username, password);
        }
        catch (SQLException ex){
            System.out.println("Connessione non avvenuta, errore");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
        }
        id = CredenzialiUtente.getId();
        String query = "SELECT DISTINCT o.idOrdine, o.dataConsegna FROM ordine o INNER JOIN farmacoordine fo ON o.idOrdine = fo.idOrdine WHERE o.idUtente = '"+id+"' AND o.stato = \"Consegnato\" AND o.ordineCaricato = \"No\"";
        Statement st = connessione.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        CheckOrdiniDaConfermare check;
        while(rs.next()){
            check = new CheckOrdiniDaConfermare(rs.getString("o.idOrdine"), rs.getString("o.dataConsegna"));
            checksList.add(check);
        }      
        return checksList;
    }

    public void mostra_check() throws ClassNotFoundException, SQLException{
        ArrayList<CheckOrdiniDaConfermare> checks = checkList();
        DefaultTableModel model = (DefaultTableModel) tabellaOrdini.getModel();
        Object[] righe = new Object[2];
        for(int i=0;i<checks.size(); i++){
            righe[0] = checks.get(i).getIdOrdine();
            righe[1] = checks.get(i).getDataConsegna();
            model.addRow(righe);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        tornaIndietroButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabellaOrdini = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(221, 221, 221));

        tornaIndietroButton.setBackground(new java.awt.Color(7, 139, 163));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Annulla");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        tabellaOrdini.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idOrdine", "Data consegna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabellaOrdini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaOrdiniMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabellaOrdini);
        if (tabellaOrdini.getColumnModel().getColumnCount() > 0) {
            tabellaOrdini.getColumnModel().getColumn(0).setHeaderValue("idOrdine");
            tabellaOrdini.getColumnModel().getColumn(1).setHeaderValue("Data consegna");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tornaIndietroButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(tornaIndietroButton)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tornaIndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornaIndietroButtonActionPerformed
        try {
            this.setVisible(false);
            GestioneOrdini go = new GestioneOrdini();
            go.setVisible(true);
            go.setResizable(false);
            go.setTitle("Pharmalink - Gestione Ordini");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(ConfermaRicezioneOrdini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void tabellaOrdiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaOrdiniMouseClicked
        int rigaSelezionata = tabellaOrdini.getSelectedRow();
        String idOrdine = tabellaOrdini.getModel().getValueAt(rigaSelezionata, 0).toString();
        System.out.println(idOrdine);
        ID_Ordine controllo = new ID_Ordine(idOrdine);
        CheckOrdiniDaConfermare_MostraFarmaci tabellaFarmaciOrdini;
        try {
            this.setVisible(false);
            tabellaFarmaciOrdini = new CheckOrdiniDaConfermare_MostraFarmaci();
            tabellaFarmaciOrdini.setVisible(true);
            tabellaFarmaciOrdini.pack();
            tabellaFarmaciOrdini.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tabellaFarmaciOrdini.toFront();
            tabellaFarmaciOrdini.setTitle("Pharmalink - Conferma Ricezione Ordini");
            tabellaFarmaciOrdini.setResizable(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConfermaRicezioneOrdini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabellaOrdiniMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabellaOrdini;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
