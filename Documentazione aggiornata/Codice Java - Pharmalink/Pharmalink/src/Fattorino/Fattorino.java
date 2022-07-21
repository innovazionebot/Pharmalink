package Fattorino;

import Autenticazione.Login;
import CredenzialiUtente.CredenzialiUtente;
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

        jPanel1 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        firmaConsegnaButton = new javax.swing.JButton();
        visualizzaConsegneButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));

        jPanel1.setBackground(new java.awt.Color(221, 221, 221));

        logoutButton.setBackground(new java.awt.Color(7, 139, 163));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        firmaConsegnaButton.setBackground(new java.awt.Color(7, 139, 163));
        firmaConsegnaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firmaConsegnaButton.setForeground(new java.awt.Color(255, 255, 255));
        firmaConsegnaButton.setText("Firma consegna");
        firmaConsegnaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firmaConsegnaButtonActionPerformed(evt);
            }
        });

        visualizzaConsegneButton.setBackground(new java.awt.Color(7, 139, 163));
        visualizzaConsegneButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        visualizzaConsegneButton.setForeground(new java.awt.Color(255, 255, 255));
        visualizzaConsegneButton.setText("Visualizza Consegne");
        visualizzaConsegneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizzaConsegneButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 139, 163));
        jLabel2.setText("Menù Fattorino");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton)
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visualizzaConsegneButton)
                    .addComponent(firmaConsegnaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(visualizzaConsegneButton)
                .addGap(18, 18, 18)
                .addComponent(firmaConsegnaButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        id = CredenzialiUtente.getId();
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
                String nome = rs.getString("utente.nome");
                String cognome = rs.getString("utente.cognome");
                String idContratto = rs.getString("contratto.idContratto");
                CredenzialiUtente controllo = new CredenzialiUtente(id, nome, cognome, idContratto);
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_firmaConsegnaButtonActionPerformed

    private void visualizzaConsegneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizzaConsegneButtonActionPerformed
        id = CredenzialiUtente.getId();
        Statement pst;
        ResultSet rs;
        try{
            String query = "SELECT * from utente, contratto WHERE id='"+id+"'";
            pst = connessione.prepareStatement(query);
            rs  = pst.executeQuery(query);    
            if(!rs.next() && id.equals(rs.getString("id"))){
                    JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                    pst.close();
                    rs.close();
                }
            else{
                this.setVisible(false);
                VisualizzaConsegne to = new VisualizzaConsegne();
                to.setVisible(true);
                to.toFront();
                to.setTitle("Pharmalink - Visualizza Consegne");
                to.setResizable(false);
                String nome = rs.getString("utente.nome");
                String cognome = rs.getString("utente.cognome");
                String idContratto = rs.getString("contratto.idContratto");
                CredenzialiUtente controllo = new CredenzialiUtente(id, nome, cognome, idContratto);
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_visualizzaConsegneButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton firmaConsegnaButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton visualizzaConsegneButton;
    // End of variables declaration//GEN-END:variables
}
