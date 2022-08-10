// concluso
package Autenticazione;

import java.awt.HeadlessException;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class RecuperaCredenziali extends javax.swing.JFrame {
    private Connection conn;
    public RecuperaCredenziali() throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "pharmalinkazienda";
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "";
        try{
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url+dbName, username, password);
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
        jLabel2 = new javax.swing.JLabel();
        nome_field = new javax.swing.JTextField();
        conferma_button = new javax.swing.JButton();
        menu_button = new javax.swing.JButton();
        nomeUtente_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));

        jPanel1.setBackground(new java.awt.Color(221, 221, 221));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 139, 163));
        jLabel2.setText("Recupera credenziali");

        nome_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        conferma_button.setBackground(new java.awt.Color(7, 139, 163));
        conferma_button.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        conferma_button.setForeground(new java.awt.Color(255, 255, 255));
        conferma_button.setText("Conferma");
        conferma_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conferma_buttonActionPerformed(evt);
            }
        });

        menu_button.setBackground(new java.awt.Color(7, 139, 163));
        menu_button.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_button.setForeground(new java.awt.Color(255, 255, 255));
        menu_button.setText("Annulla");
        menu_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_buttonActionPerformed(evt);
            }
        });

        nomeUtente_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeUtente_label.setText("Inserisci E-mail");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(menu_button)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(conferma_button))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(nomeUtente_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nome_field, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeUtente_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu_button)
                    .addComponent(conferma_button))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conferma_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conferma_buttonActionPerformed
        String email = nome_field.getText().toLowerCase();
        if (email.length()>0){
            Statement pst;
            ResultSet rs;
            try{
                String query = "SELECT email, password FROM utente WHERE email='"+email+"'";
                pst = conn.prepareStatement(query);
                rs  = pst.executeQuery(query);
                if(!rs.next()){
                    JOptionPane.showMessageDialog(null,"Non risulti registrato nel nostro database.\nControlla se l'email inserita è corretta", "Errore", JOptionPane.WARNING_MESSAGE);
                    pst.close();
                    rs.close();
                    return;
                }
                if(email.equals(rs.getString("email"))){
                    JOptionPane.showMessageDialog(null, "Un'email è stata inviata al tuo indirizzo email.\nVerifica la tua INBOX.", "Conferma invio email", JOptionPane.PLAIN_MESSAGE);
                    String to = email;
                    String from = "vivereingegneriainnovazione@gmail.com";
                    String host = "smtp.gmail.com";
                    Properties properties = System.getProperties();
                    properties.put("mail.smtp.host", host);
                    properties.put("mail.smtp.port", "465");
                    properties.put("mail.smtp.auth", "true");
                    properties.put("mail.smtp.ssl.enable", "true");
                    properties.put("mail.smtp.socketFactory.port", "465");
                    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    properties.put("mail.debug", "true");
                    Session session = Session.getInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from, "bpplzhtnpcspsfje");
                        }
                    });
                    session.setDebug(true);
                    try{
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(from));
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                        message.setSubject("Recupero credenziali Pharmalink");
                        message.setText("Salve,\n\nIn allegato le credenziali richieste:\n\nEmail: "+rs.getString("email")+"\nPassword: "+rs.getString("password")+"\n\nLe auguriamo un buon proseguimento di giornata.\n\nCordiali saluti,\nPharmalink");
                        Transport.send(message);
                        this.setVisible(false);
                        Login log = new Login();
                        log.setVisible(true);
                        log.setResizable(false);
                        log.setTitle("Pharmalink - Autenticazione");
                    }
                    catch(MessagingException mex){
                        mex.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Errore");
                }
            }
            catch(HeadlessException | ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else{
            JFrame frame;
            frame = new JFrame("Errore");
            JOptionPane.showMessageDialog(frame,"Email campo vuoto", "Errore", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_conferma_buttonActionPerformed

    private void menu_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_buttonActionPerformed
        this.setVisible(false);
        try {
            Login log = new Login();
            log.toFront();
            log.setVisible(true);
            log.getContentPane().setBackground(new java.awt.Color(198,231,201));
            log.setResizable(false);
            log.setTitle("Pharmalink - Autenticazione");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecuperaCredenziali.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menu_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conferma_button;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton menu_button;
    private javax.swing.JLabel nomeUtente_label;
    private javax.swing.JTextField nome_field;
    // End of variables declaration//GEN-END:variables
}
