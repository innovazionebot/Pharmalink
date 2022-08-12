package Farmacista;

import Autenticazione.Login;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import CredenzialiUtente.CredenzialiUtente;
import java.awt.HeadlessException;

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
        titolo = new javax.swing.JLabel();
        ordinaFarmaciButton = new javax.swing.JButton();
        gestioneOrdiniButton = new javax.swing.JButton();
        contrattiPeriodiciButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        titolo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titolo.setForeground(new java.awt.Color(7, 139, 163));
        titolo.setText("Menù Farmacista");

        ordinaFarmaciButton.setBackground(new java.awt.Color(7, 139, 163));
        ordinaFarmaciButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ordinaFarmaciButton.setForeground(new java.awt.Color(255, 255, 255));
        ordinaFarmaciButton.setText("Ordina Farmaci");
        ordinaFarmaciButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordinaFarmaciButtonActionPerformed(evt);
            }
        });

        gestioneOrdiniButton.setBackground(new java.awt.Color(7, 139, 163));
        gestioneOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gestioneOrdiniButton.setForeground(new java.awt.Color(255, 255, 255));
        gestioneOrdiniButton.setText("Gestione Ordini");
        gestioneOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestioneOrdiniButtonActionPerformed(evt);
            }
        });

        contrattiPeriodiciButton.setBackground(new java.awt.Color(7, 139, 163));
        contrattiPeriodiciButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contrattiPeriodiciButton.setForeground(new java.awt.Color(255, 255, 255));
        contrattiPeriodiciButton.setText("Contratti Periodici");
        contrattiPeriodiciButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrattiPeriodiciButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(contrattiPeriodiciButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ordinaFarmaciButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gestioneOrdiniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titolo))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titolo)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(contrattiPeriodiciButton)
                .addGap(18, 18, 18)
                .addComponent(ordinaFarmaciButton)
                .addGap(18, 18, 18)
                .addComponent(gestioneOrdiniButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        try {
            this.setVisible(false);
            Login log = new Login();
            log.setVisible(true);
            log.setResizable(false);
            log.setTitle("Pharmalink - Autenticazione");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void ordinaFarmaciButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordinaFarmaciButtonActionPerformed
        id = CredenzialiUtente.getId();
        Statement pst;
        ResultSet rs;
        try{
            String query = "SELECT * from utente WHERE id='"+id+"'";
            pst = connessione.prepareStatement(query);
            rs  = pst.executeQuery(query);
            if(!rs.next() && id.equals(rs.getString("id"))){
                JOptionPane.showMessageDialog(null,"Errore durante l'esecuzione del processo", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
                pst.close();
                rs.close();
            }
        else{
            this.setVisible(false);
            OrdinaFarmaco mc = new OrdinaFarmaco();
            mc.setVisible(true);
            mc.toFront();
            mc.setTitle("Pharmalink - Ordina farmaco");
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_ordinaFarmaciButtonActionPerformed

    private void gestioneOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestioneOrdiniButtonActionPerformed
        id = CredenzialiUtente.getId();
        Statement pst;
        ResultSet rs;
        try{
            String query = "SELECT * from utente WHERE id='"+id+"'";
            pst = connessione.prepareStatement(query);
            rs  = pst.executeQuery(query);
            if(!rs.next() && id.equals(rs.getString("id"))){
                JOptionPane.showMessageDialog(null,"Errore durante l'esecuzione del processo", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
                pst.close();
                rs.close();
            }
        else{
            this.setVisible(false);
            GestioneOrdini go = new GestioneOrdini();
            go.setVisible(true);
            go.toFront();
            go.setTitle("Pharmalink - Gestione Ordini");
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_gestioneOrdiniButtonActionPerformed

    private void contrattiPeriodiciButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrattiPeriodiciButtonActionPerformed
        id = CredenzialiUtente.getId();
        Statement pst;
        ResultSet rs;
        try{
            String query = "SELECT * from utente WHERE id='"+id+"'";
            pst = connessione.prepareStatement(query);
            rs  = pst.executeQuery(query);
            if(!rs.next() && id.equals(rs.getString("id"))){
                JOptionPane.showMessageDialog(null,"Errore durante l'esecuzione del processo", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
                pst.close();
                rs.close();
            }
        else{
            this.setVisible(false);
            ModificaParametri gcp = new ModificaParametri();
            gcp.setVisible(true);
            gcp.toFront();
            gcp.setTitle("Pharmalink - Gestione Contratti Periodici");
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_contrattiPeriodiciButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contrattiPeriodiciButton;
    private javax.swing.JButton gestioneOrdiniButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton ordinaFarmaciButton;
    private javax.swing.JLabel titolo;
    // End of variables declaration//GEN-END:variables

}
