package Farmacista;

import CredenzialiUtente.CredenzialiUtente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StoricoOrdini extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public StoricoOrdini() throws ClassNotFoundException, SQLException{
        initComponents();
        mostra_storico();
    }
    
public ArrayList<Ordini> storicoList() throws ClassNotFoundException, SQLException{
    ArrayList<Ordini> storiciList = new ArrayList<>();
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
    String query = "SELECT idOrdine, dataOrdine, dataConsegna, stato FROM ordine WHERE idUtente = '"+id+"' AND (stato = \"Consegnato\" OR stato = \"Errore\")";
    //String query = "SELECT idOrdine, dataOrdine, dataConsegna, stato FROM ordine WHERE idUtente = '"+id+"'";
    Statement st = connessione.createStatement();
    ResultSet rs = st.executeQuery(query);
    Ordini ordini;
    while(rs.next()){
        ordini = new Ordini(rs.getString("idOrdine"), rs.getString("dataOrdine"), rs.getString("dataConsegna"), rs.getString("stato"));
        storiciList.add(ordini);
    }      
    return storiciList;
}

    public void mostra_storico() throws ClassNotFoundException, SQLException{
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
        if(storici.size()==0){
            jLabel1.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaStorici = new javax.swing.JTable();
        annullaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabellaStorici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ordine", "Data Ordine", "Data Consegna", "Stato"
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

        annullaButton.setBackground(new java.awt.Color(7, 139, 163));
        annullaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        annullaButton.setForeground(new java.awt.Color(255, 255, 255));
        annullaButton.setText("Annulla");
        annullaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Nessun ordine");
        jLabel1.setVisible(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(annullaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annullaButton)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annullaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaButtonActionPerformed
        try {
            this.setVisible(false);
            GestioneOrdini go = new GestioneOrdini();
            go.setVisible(true);
            go.setResizable(false);
            go.setTitle("Pharmalink - Gestione Ordini");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(StoricoOrdini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_annullaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaStorici;
    // End of variables declaration//GEN-END:variables
}
