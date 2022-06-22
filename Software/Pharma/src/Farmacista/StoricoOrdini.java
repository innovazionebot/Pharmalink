package Farmacista;

import IndirizzoIP.IndirizzoIP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StoricoOrdini extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idContratto;
    public StoricoOrdini() throws ClassNotFoundException{
        initComponents();
        mostra_storico();
    }
    
public ArrayList<Ordini> storicoList() throws ClassNotFoundException{
        ArrayList<Ordini> storiciList = new ArrayList<>();
        try{
            IndirizzoIP address = new IndirizzoIP();
            String url = "jdbc:mysql://" + address.ip + "/";
            String dbName = "pharmalinkazienda";
            String driver = "com.mysql.cj.jdbc.Driver";
            String username = "root";
            String password = "";
            Class.forName(driver);
            this.connessione = DriverManager.getConnection(url+dbName, username, password);
            id = CheckID.getID();
            idContratto = CheckContratto.getID();
            String query = "SELECT idOrdine, dataOrdine, dataConsegna, stato FROM ordine WHERE idUtente = '"+id+"' AND (stato = \"Consegnato\" OR stato = \"Errore\")";
            Statement st = connessione.createStatement();
            ResultSet rs = st.executeQuery(query);
            Ordini ordini;
            while(rs.next()){
                ordini = new Ordini(rs.getString("idOrdine"), rs.getString("dataOrdine"), rs.getString("dataConsegna"), rs.getString("stato"));
                storiciList.add(ordini);
            }      
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex);
        }
        return storiciList;
    }

    public void mostra_storico() throws ClassNotFoundException{
        ArrayList<Ordini> storici = storicoList();
        DefaultTableModel model = (DefaultTableModel) tabellaStorici.getModel();
        Object[] righe = new Object[4];
        for(int i=0;i<storici.size(); i++){
            righe[0] = storici.get(i).getIdOrdine();
            righe[1] = storici.get(i).getDataOrdine();
            righe[2] = storici.get(i).getDataConsegna();
            righe[3] = storici.get(i).getStato();
            model.addRow(righe);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaStorici = new javax.swing.JTable();
        tornaIndietroButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabellaStorici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ordine", "Data Attuale", "Data Consegna", "Stato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabellaStorici);

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Torna indietro");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tornaIndietroButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tornaIndietroButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tornaIndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornaIndietroButtonActionPerformed
        JFrame frame;
        frame = new JFrame("Uscita");
        frame.setResizable(false);
        if (JOptionPane.showConfirmDialog(frame, "Sei sicuro di voler abbandonare la pagina?", "Avviso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION){
            try {
                this.toBack();
                this.setVisible(false);
                GestioneOrdini gcf = new GestioneOrdini();
                gcf.toFront();
                gcf.setVisible(true);
                gcf.setTitle("Pharmalink - Gestione Ordini");
                gcf.setResizable(false);
                gcf.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaStorici;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
