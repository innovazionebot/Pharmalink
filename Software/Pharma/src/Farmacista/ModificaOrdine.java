package Farmacista;

import IndirizzoIP.IndirizzoIP;
import com.mysql.cj.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ModificaOrdine extends javax.swing.JFrame{
    private Connection connessione;
    private String id, idContratto;
    public ModificaOrdine() throws ClassNotFoundException{
        initComponents();
        BindCombo();
    }
    public void BindCombo(){
        MostraOrdini mo = new MostraOrdini();
        HashMap<String, String> map = mo.populateCombo();
        for(String s : map.keySet()){
            selettoreOrdine.addItem(s);
        }
    }
    
    public ArrayList<Catalogo> farmacoList() throws ClassNotFoundException{
        ArrayList<Catalogo> farmaciList = new ArrayList<>();
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
            String query = "SELECT f.idFarmaco, f.nome, f.principio, scadenza, quantita FROM farmaco";
            Statement st = connessione.createStatement();
            ResultSet rs = st.executeQuery(query);
            Catalogo catalogo;
            while(rs.next()){
                catalogo = new Catalogo(rs.getString("idFarmaco"), rs.getString("nome"), rs.getString("principio"), rs.getString("scadenza"), rs.getString("quantita"));
                farmaciList.add(catalogo);
            }      
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex);
        }
        return farmaciList;
    }

    public void mostra_farmaci() throws ClassNotFoundException, SQLException{
        ArrayList<Catalogo> farmaci = farmacoList();
        DefaultTableModel model = (DefaultTableModel) tabellaModifica.getModel();
        Object[] righe = new Object[5];
        for(int i=0;i<farmaci.size(); i++){
            righe[0] = farmaci.get(i).getIdFarmaco();
            righe[1] = farmaci.get(i).getNomeFarmaco();
            righe[2] = farmaci.get(i).getPrincipio();
            righe[3] = farmaci.get(i).getScadenza();
            righe[4] = farmaci.get(i).getQuantita();
            model.addRow(righe);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaModifica = new javax.swing.JTable();
        tornaIndietroButton = new javax.swing.JButton();
        selettoreOrdine = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabellaModifica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idFarmaco", "Nome", "Principio", "Scadenza", "Disponibili", "Quantita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabellaModifica.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabellaModifica);

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Torna al menù principale");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        selettoreOrdine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selettoreOrdineActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tornaIndietroButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selettoreOrdine, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selettoreOrdine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
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
                Logger.getLogger(ModificaOrdine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void selettoreOrdineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selettoreOrdineActionPerformed
        MostraOrdini mq = new MostraOrdini();
        HashMap<String, String> map = mq.populateCombo();
        ResultSet st;
        PreparedStatement pst;
    }//GEN-LAST:event_selettoreOrdineActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selettoreOrdine;
    private javax.swing.JTable tabellaModifica;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
