package Farmacista;

import Login.Login;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Farmacista extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public Farmacista() throws ClassNotFoundException {
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
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        logoutButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        gestioneOrdiniButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        gestioneContrattoButton = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutButton.setBackground(new java.awt.Color(204, 0, 0));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Gestione Merci");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gestioneOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gestioneOrdiniButton.setText("Traccia i miei ordini");
        gestioneOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestioneOrdiniButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Pharmalink - Menù principale");

        gestioneContrattoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gestioneContrattoButton.setText("Gestione Contratto");
        gestioneContrattoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestioneContrattoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(logoutButton)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gestioneOrdiniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(gestioneContrattoButton))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(gestioneContrattoButton)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(gestioneOrdiniButton)
                .addGap(13, 13, 13)
                .addComponent(logoutButton)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        JFrame frame;
        frame = new JFrame("Uscita");
        frame.setResizable(false);
        if (JOptionPane.showConfirmDialog(frame, "Sei sicuro di voler uscire?", "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION){
            try {
                this.setVisible(false);
                Login log = new Login();
                log.toFront();
                log.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void gestioneOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestioneOrdiniButtonActionPerformed
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
                System.out.println("Benvenuto "+rs.getString("nome")+" "+rs.getString("cognome"));
                this.setVisible(false);
                TracciaOrdini to = new TracciaOrdini();
                to.toFront();
                to.setVisible(true);
                //id = rs.getString("id");
                CheckID controllo = new CheckID(id);
            }
        }
        catch(HeadlessException | SQLException  e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_gestioneOrdiniButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void gestioneContrattoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestioneContrattoButtonActionPerformed
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
                System.out.println("Benvenuto "+rs.getString("nome")+" "+rs.getString("cognome"));
                this.setVisible(false);
                ModificaParametri gcf = new ModificaParametri();
                gcf.toFront();
                gcf.setVisible(true);
                //id = rs.getString("id");
                CheckID controllo = new CheckID(id);
            }
        }
        catch(ClassNotFoundException | HeadlessException | SQLException  e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_gestioneContrattoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gestioneContrattoButton;
    private javax.swing.JButton gestioneOrdiniButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JButton logoutButton;
    // End of variables declaration//GEN-END:variables

}
