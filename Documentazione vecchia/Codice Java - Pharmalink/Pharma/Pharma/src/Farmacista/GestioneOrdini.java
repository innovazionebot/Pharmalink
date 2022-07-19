package Farmacista;

import IndirizzoIP.IndirizzoIP;
import Login.Login;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GestioneOrdini extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public GestioneOrdini() throws ClassNotFoundException{
        this.getContentPane().setBackground(new java.awt.Color(198,231,201));
        IndirizzoIP address = new IndirizzoIP();
        String url = "jdbc:mysql://" + address.ip + "/";
        String dbName = "pharmalinkazienda";
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "";
        try{
            Class.forName(driver);
            this.connessione = DriverManager.getConnection(url+dbName, username, password);
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tracciaOrdiniButton = new javax.swing.JButton();
        storicoOrdiniButton = new javax.swing.JButton();
        modificaOrdineButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tornaIndietroButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));

        tracciaOrdiniButton.setBackground(new java.awt.Color(4, 76, 208));
        tracciaOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tracciaOrdiniButton.setForeground(new java.awt.Color(255, 255, 255));
        tracciaOrdiniButton.setText("Traccia i miei ordini");
        tracciaOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tracciaOrdiniButtonActionPerformed(evt);
            }
        });

        storicoOrdiniButton.setBackground(new java.awt.Color(4, 76, 208));
        storicoOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        storicoOrdiniButton.setForeground(new java.awt.Color(255, 255, 255));
        storicoOrdiniButton.setText("Storico ordini");
        storicoOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storicoOrdiniButtonActionPerformed(evt);
            }
        });

        modificaOrdineButton.setBackground(new java.awt.Color(4, 76, 208));
        modificaOrdineButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        modificaOrdineButton.setForeground(new java.awt.Color(255, 255, 255));
        modificaOrdineButton.setText("Modifica Ordine");
        modificaOrdineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaOrdineButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Gestione Ordini");

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tornaIndietroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(106, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(storicoOrdiniButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modificaOrdineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tracciaOrdiniButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tracciaOrdiniButton)
                .addGap(31, 31, 31)
                .addComponent(storicoOrdiniButton)
                .addGap(31, 31, 31)
                .addComponent(modificaOrdineButton)
                .addGap(31, 31, 31)
                .addComponent(tornaIndietroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                Farmacista gcf = new Farmacista();
                gcf.toFront();
                gcf.setVisible(true);
                gcf.setTitle("Pharmalink - Menù Farmacista");
                gcf.setResizable(false);
                gcf.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void tracciaOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tracciaOrdiniButtonActionPerformed
        id = CheckID.getID();
        Statement pst;
        ResultSet rs;
        try{
            String query = "SELECT * from utente WHERE id='"+id+"'";
            pst = connessione.prepareStatement(query);
            rs  = pst.executeQuery(query);
            if(!rs.next() && id.equals(rs.getString("id"))){
                    JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                    pst.close();
                    rs.close();
                }
            else{
                this.setVisible(false);
                TracciaOrdini to = new TracciaOrdini();
                to.setVisible(true);
                to.toFront();
                to.setTitle("Pharmalink - Traccia Ordini");
                to.getContentPane().setBackground(new java.awt.Color(198,231,201));
                CheckID controllo = new CheckID(id);
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tracciaOrdiniButtonActionPerformed

    private void storicoOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storicoOrdiniButtonActionPerformed
        id = CheckID.getID();
        Statement pst;
        ResultSet rs;
        try{
            String query = "SELECT * from utente WHERE id='"+id+"'";
            pst = connessione.prepareStatement(query);
            rs  = pst.executeQuery(query);
            if(!rs.next() && id.equals(rs.getString("id"))){
                    JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                    pst.close();
                    rs.close();
                }
            else{
                this.setVisible(false);
                StoricoOrdini so = new StoricoOrdini();
                so.setVisible(true);
                so.toFront();
                so.setTitle("Pharmalink - Storico Ordini");
                so.getContentPane().setBackground(new java.awt.Color(198,231,201));
                CheckID controllo = new CheckID(id);
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_storicoOrdiniButtonActionPerformed

    private void modificaOrdineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaOrdineButtonActionPerformed
        id = CheckID.getID();
        Statement pst;
        ResultSet rs;
        try{
            String query = "SELECT * from utente WHERE id='"+id+"'";
            pst = connessione.prepareStatement(query);
            rs  = pst.executeQuery(query);
            if(!rs.next() && id.equals(rs.getString("id"))){
                    JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                    pst.close();
                    rs.close();
                }
            else{
                this.setVisible(false);
                ModificaOrdine mo = new ModificaOrdine();
                mo.setVisible(true);
                mo.toFront();
                mo.setTitle("Pharmalink - Modifica Ordine");
                mo.getContentPane().setBackground(new java.awt.Color(198,231,201));
                CheckID controllo = new CheckID(id);
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(GestioneOrdini.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_modificaOrdineButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modificaOrdineButton;
    private javax.swing.JButton storicoOrdiniButton;
    private javax.swing.JButton tornaIndietroButton;
    private javax.swing.JButton tracciaOrdiniButton;
    // End of variables declaration//GEN-END:variables
}
