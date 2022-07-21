package Fattorino;

import Autenticazione.Login;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Fattorino extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public Fattorino() throws ClassNotFoundException {
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
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        firmaConsegnaButton = new javax.swing.JButton();
        presaInCaricoButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));

        logoutButton.setBackground(new java.awt.Color(204, 0, 0));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        firmaConsegnaButton.setBackground(new java.awt.Color(4, 76, 208));
        firmaConsegnaButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        firmaConsegnaButton.setForeground(new java.awt.Color(255, 255, 255));
        firmaConsegnaButton.setText("Firma consegna");
        firmaConsegnaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firmaConsegnaButtonActionPerformed(evt);
            }
        });

        presaInCaricoButton.setBackground(new java.awt.Color(4, 76, 208));
        presaInCaricoButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        presaInCaricoButton.setForeground(new java.awt.Color(255, 255, 255));
        presaInCaricoButton.setText("Presa in carico");
        presaInCaricoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presaInCaricoButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Menù Fattorino");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(firmaConsegnaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presaInCaricoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(presaInCaricoButton)
                .addGap(55, 55, 55)
                .addComponent(firmaConsegnaButton)
                .addGap(36, 36, 36)
                .addComponent(logoutButton)
                .addContainerGap())
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
                log.getContentPane().setBackground(new java.awt.Color(198,231,201));
                log.toFront();
                log.setResizable(false);
                log.setVisible(true);
                log.setTitle("Pharmalink - Autenticazione");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Fattorino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void firmaConsegnaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firmaConsegnaButtonActionPerformed
        id = CheckIDFattorino.getID();
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
                FirmaConsegna to = new FirmaConsegna();
                to.setVisible(true);
                to.toFront();
                to.setTitle("Pharmalink - Firma Consegna");
                to.setResizable(false);
                to.getContentPane().setBackground(new java.awt.Color(198,231,201));
                CheckIDFattorino controllo = new CheckIDFattorino(id);
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_firmaConsegnaButtonActionPerformed

    private void presaInCaricoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presaInCaricoButtonActionPerformed
        id = CheckIDFattorino.getID();
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
                PresaInCarico to = new PresaInCarico();
                to.setVisible(true);
                to.toFront();
                to.setTitle("Pharmalink - Presa in carico");
                to.setResizable(false);
                to.getContentPane().setBackground(new java.awt.Color(198,231,201));
                CheckIDFattorino controllo = new CheckIDFattorino(id);
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_presaInCaricoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton firmaConsegnaButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton presaInCaricoButton;
    // End of variables declaration//GEN-END:variables
}
