package Farmacista;

import IndirizzoIP.IndirizzoIP;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CheckOrdine extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public CheckOrdine() throws ClassNotFoundException {
        initComponents();
        mostra_check();
    }

    public ArrayList<Check> checkList() throws ClassNotFoundException{
       ArrayList<Check> checksList = new ArrayList<>();
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
           String query = "SELECT DISTINCT o.idOrdine, o.dataConsegna FROM ordine o INNER JOIN farmacoordine fo ON o.idOrdine = fo.idOrdine WHERE o.idUtente = '"+id+"' AND o.stato = \"Consegnato\" AND fo.ordineCaricato = \"No\"";
           Statement st = connessione.prepareStatement(query);
           ResultSet rs = st.executeQuery(query);
           Check check;
           while(rs.next()){
               check = new Check(rs.getString("o.idOrdine"), rs.getString("o.dataConsegna"));
               checksList.add(check);
           }      
       }
       catch (SQLException ex){
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
           JOptionPane.showMessageDialog(null, ex);
       }
       return checksList;
    }

    public void mostra_check() throws ClassNotFoundException{
        ArrayList<Check> checks = checkList();
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

        jPanel1 = new javax.swing.JPanel();
        confermaButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ElencoOrdini = new javax.swing.JTable();
        tornaIndietroButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabellaOrdini = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        confermaButton.setBackground(new java.awt.Color(0, 204, 51));
        confermaButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Conferma");
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        ElencoOrdini.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ElencoOrdini);
        if (ElencoOrdini.getColumnModel().getColumnCount() > 0) {
            ElencoOrdini.getColumnModel().getColumn(0).setHeaderValue("idOrdine");
            ElencoOrdini.getColumnModel().getColumn(1).setHeaderValue("Data consegna");
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Torna al menù principale");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tornaIndietroButton)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                Farmacista f = new Farmacista();
                f.toFront();
                f.setVisible(true);
                f.setTitle("Pharmalink - Fattorino Menù");
                f.setResizable(false);
                f.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (Exception ex) {
                Logger.getLogger(CheckOrdine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed

    }//GEN-LAST:event_confermaButtonActionPerformed

    private void tabellaOrdiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaOrdiniMouseClicked
        int rigaSelezionata = tabellaOrdini.getSelectedRow();
        String idOrdine = tabellaOrdini.getModel().getValueAt(rigaSelezionata, 0).toString();
        System.out.println(idOrdine);
        ID_Ordine controllo = new ID_Ordine(idOrdine);
        MostraFarmaci tabellaFarmaciOrdini;
        try {
            this.setVisible(false);
            tabellaFarmaciOrdini = new MostraFarmaci();
            tabellaFarmaciOrdini.setVisible(true);
            tabellaFarmaciOrdini.pack();
            tabellaFarmaciOrdini.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tabellaFarmaciOrdini.toFront();
            tabellaFarmaciOrdini.setTitle("Pharmalink - Check Ordine");
            tabellaFarmaciOrdini.setResizable(true);
            tabellaFarmaciOrdini.getContentPane().setBackground(new java.awt.Color(198,231,201));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckOrdine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabellaOrdiniMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ElencoOrdini;
    private javax.swing.JButton confermaButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabellaOrdini;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
