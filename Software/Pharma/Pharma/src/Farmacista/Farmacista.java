package Farmacista;

import IndirizzoIP.*;
import Login.Login;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Farmacista extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public Farmacista() throws ClassNotFoundException {
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        logoutButton = new javax.swing.JButton();
        CatalogoButton = new javax.swing.JButton();
        tracciaButton = new javax.swing.JButton();
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

        CatalogoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CatalogoButton.setText("Catalogo");
        CatalogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatalogoButtonActionPerformed(evt);
            }
        });

        tracciaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tracciaButton.setText("Traccia i miei ordini");
        tracciaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tracciaButtonActionPerformed(evt);
            }
        });

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
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(logoutButton)
                    .addComponent(CatalogoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tracciaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gestioneContrattoButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gestioneContrattoButton)
                .addGap(18, 18, 18)
                .addComponent(CatalogoButton)
                .addGap(18, 18, 18)
                .addComponent(tracciaButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tracciaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tracciaButtonActionPerformed
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
                to.setResizable(false);
                CheckID controllo = new CheckID(id);
            }
        }
        catch(HeadlessException | SQLException  e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tracciaButtonActionPerformed

    private void CatalogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatalogoButtonActionPerformed
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
                GestioneMerci mc = new GestioneMerci();
                mc.setVisible(true);
                mc.toFront();
                mc.setTitle("Pharmalink - Gestione Merci");
                mc.setResizable(false);
                CheckID controllo = new CheckID(id);
            }
        }
        catch(HeadlessException | SQLException  e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CatalogoButtonActionPerformed
    
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
                this.setVisible(false);
                ModificaParametri gcf = new ModificaParametri();
                gcf.setVisible(true);
                gcf.toFront();
                gcf.setTitle("Pharmalink - Gestione Contratto");
                gcf.setResizable(false);
                CheckID controllo = new CheckID(id);
            }
        }
        catch(ClassNotFoundException | HeadlessException | SQLException  e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_gestioneContrattoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CatalogoButton;
    private javax.swing.JButton gestioneContrattoButton;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton tracciaButton;
    // End of variables declaration//GEN-END:variables

}
