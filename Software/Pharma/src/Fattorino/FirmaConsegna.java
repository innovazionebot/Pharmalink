package Fattorino;

import IndirizzoIP.IndirizzoIP;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FirmaConsegna extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public FirmaConsegna() throws ClassNotFoundException {
        IndirizzoIP address = new IndirizzoIP();
        String url = "jdbc:mysql://" + address.ip + "/";
        //String url = "jdbc:mysql://localhost:3306/";
        //String url = "jdbc:mysql://5.tcp.eu.ngrok.io:10833/";
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
        }
        initComponents();
        emailField.setText("");
        passwordField.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password_label = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        titoloLogin = new javax.swing.JLabel();
        tornaIndietroButton = new javax.swing.JButton();
        confermaButton = new javax.swing.JButton();
        nomeUtente_label = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        password_label.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        password_label.setText("Password");

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        titoloLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titoloLogin.setText("Conferma Consegna");

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Torna al menù principale");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        confermaButton.setBackground(new java.awt.Color(0, 204, 51));
        confermaButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Conferma");
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });

        nomeUtente_label.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        nomeUtente_label.setText("Email");

        emailField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(tornaIndietroButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(confermaButton)
                .addGap(3, 3, 3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(titoloLogin)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeUtente_label)
                            .addComponent(password_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titoloLogin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeUtente_label))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_label)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tornaIndietroButton)
                    .addComponent(confermaButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed

    }//GEN-LAST:event_passwordFieldActionPerformed

    private void tornaIndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornaIndietroButtonActionPerformed
        JFrame frame;
        frame = new JFrame("Uscita");
        frame.setResizable(false);
        if (JOptionPane.showConfirmDialog(frame, "Sei sicuro di voler abbandonare la pagina?", "Avviso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION){
            try {
                this.toBack();
                this.setVisible(false);
                Fattorino f = new Fattorino();
                f.toFront();
                f.setVisible(true);
                f.setTitle("Pharmalink - Fattorino Menù");
                f.setResizable(false);
                f.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PresaInCarico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        ResultSet rs;
        Statement st;
        PreparedStatement pst, pst2;
        try{
            String email = emailField.getText().toLowerCase();
            String password = new String(passwordField.getPassword());
            String idOrdinePC = IDOrdine_PC.getIdOrdine();
            System.out.println(idOrdinePC);
            String query = "SELECT u.email, u.password, o.idOrdine FROM utente u INNER JOIN ordine o ON u.id = o.idUtente AND o.stato = \"In consegna\" AND o.idOrdine = '"+idOrdinePC+"'";
            st = connessione.prepareStatement(query);
            rs = st.executeQuery(query);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Nessun ordine da firmare", "Errore", JOptionPane.WARNING_MESSAGE);
                st.close();
                rs.close();
            }
            else{
                String emailDBMS = rs.getString("u.email");
                String passwordDBMS = rs.getString("u.password");
                String idOrdine = rs.getString("o.idOrdine");
                if(email.equals(emailDBMS) && password.equals(passwordDBMS)){
                    String query2 = "UPDATE ordine SET stato = \"Consegnato\", note = \"Nessun errore durante la fase di consegna\" WHERE idOrdine = '"+idOrdine+"'";
                    pst = connessione.prepareStatement(query2);
                    pst.executeUpdate();
                    id = CheckIDFattorino.getID();
                    System.out.println("ID fattorino: "+ id);
                    String query3 = "UPDATE utente SET flag = 0 WHERE id = '"+id+"'";
                    pst2 = connessione.prepareStatement(query3);
                    pst2.executeUpdate();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Le credenziali inserite sono errate.", "Errore durante la conferma", JOptionPane.WARNING_MESSAGE);
                }
            }
            this.setVisible(false);
            Fattorino gm = new Fattorino();
            gm.setVisible(true);
            gm.toFront();
            gm.setTitle("Pharmalink - Menù Fattorino");
            gm.setResizable(false);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FirmaConsegna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed

    }//GEN-LAST:event_emailFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel nomeUtente_label;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel password_label;
    private javax.swing.JLabel titoloLogin;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
