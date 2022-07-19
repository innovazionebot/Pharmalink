// concluso
package Login;

import IndirizzoIP.IndirizzoIP;
import Login.Login;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.swing.*;

public class recuperaCredenziali extends javax.swing.JFrame {
    private Connection conn;
    public recuperaCredenziali() {
        IndirizzoIP address = new IndirizzoIP();
        String url = "jdbc:mysql://" + address.ip + "/";
        String dbName = "pharmalinkazienda";
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "";
        try{
            Class.forName(driver);
            this.conn = (Connection)DriverManager.getConnection(url+dbName, username, password);
        }
        catch (ClassNotFoundException | SQLException ex){
            System.out.println("Errore durante la comunicazione con il dbms");
            System.out.println("SQLException: " + ex.getMessage());
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        conferma_button = new javax.swing.JButton();
        menu_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));

        nome_field.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nome_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_fieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("Inserisci email");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Recupera credenziali");

        conferma_button.setBackground(new java.awt.Color(0, 204, 51));
        conferma_button.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        conferma_button.setForeground(new java.awt.Color(255, 255, 255));
        conferma_button.setText("Conferma");
        conferma_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conferma_buttonActionPerformed(evt);
            }
        });

        menu_button.setBackground(new java.awt.Color(204, 0, 0));
        menu_button.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menu_button.setForeground(new java.awt.Color(255, 255, 255));
        menu_button.setText("Torna indietro");
        menu_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(nome_field, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menu_button, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addGap(108, 108, 108)
                        .addComponent(conferma_button, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conferma_button)
                    .addComponent(menu_button))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nome_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_fieldActionPerformed

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
                    //JOptionPane.showMessageDialog(null, "Un'email è stata inviata al tuo indirizzo email.\nVerifica la tua INBOX.", "Conferma invio email", JOptionPane.PLAIN_MESSAGE);
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
                        System.out.println("Sto mandando l'email");
                        Transport.send(message);
                        System.out.println("Email mandata con successo, verificate la vostra INBOX");
                        Login log = new Login();
                        log.toFront();
                        log.setVisible(true);
                    }
                    catch(MessagingException mex){
                        mex.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Errore");
                }
            }
            catch(Exception e){
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
            Logger.getLogger(recuperaCredenziali.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menu_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conferma_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton menu_button;
    private javax.swing.JTextField nome_field;
    // End of variables declaration//GEN-END:variables
}
