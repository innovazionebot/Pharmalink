// concluso
package Login;

// Librerie
import Farmacista.CheckContratto;
import Magazziniere.Magazziniere;
import Fattorino.Fattorino;
import Farmacista.CheckID;
import Farmacista.Farmacista;
import IndirizzoIP.IndirizzoIP;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.*;

public class Login extends javax.swing.JFrame {
    private Connection connessione;
    public Login() throws ClassNotFoundException{
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titoloLogin = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        nomeUtente_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        esci_button = new javax.swing.JButton();
        reimpostaValori_button = new javax.swing.JButton();
        accedi_button = new javax.swing.JButton();
        recuperaCredenziali_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(447, 349));

        titoloLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titoloLogin.setText("Autenticazione");

        email_field.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        email_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_fieldActionPerformed(evt);
            }
        });

        password_field.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        nomeUtente_label.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        nomeUtente_label.setText("Email");

        password_label.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        password_label.setText("Password");

        esci_button.setBackground(new java.awt.Color(204, 0, 0));
        esci_button.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        esci_button.setForeground(new java.awt.Color(255, 255, 255));
        esci_button.setText("Esci");
        esci_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esci_buttonActionPerformed(evt);
            }
        });

        reimpostaValori_button.setBackground(new java.awt.Color(4, 76, 208));
        reimpostaValori_button.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        reimpostaValori_button.setForeground(new java.awt.Color(255, 255, 255));
        reimpostaValori_button.setText("Reimposta valori");
        reimpostaValori_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reimpostaValori_buttonActionPerformed(evt);
            }
        });

        accedi_button.setBackground(new java.awt.Color(0, 204, 51));
        accedi_button.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        accedi_button.setForeground(new java.awt.Color(255, 255, 255));
        accedi_button.setText("Accedi");
        accedi_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accedi_buttonActionPerformed(evt);
            }
        });

        recuperaCredenziali_button.setBackground(new java.awt.Color(255, 204, 0));
        recuperaCredenziali_button.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        recuperaCredenziali_button.setForeground(new java.awt.Color(255, 255, 255));
        recuperaCredenziali_button.setText("Recupera credenziali");
        recuperaCredenziali_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuperaCredenziali_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(reimpostaValori_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(esci_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(accedi_button))
                    .addComponent(recuperaCredenziali_button, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeUtente_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(titoloLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(titoloLogin)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeUtente_label)
                    .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_label)
                    .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reimpostaValori_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recuperaCredenziali_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(esci_button)
                    .addComponent(accedi_button))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void email_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_fieldActionPerformed

    }//GEN-LAST:event_email_fieldActionPerformed

    private void reimpostaValori_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reimpostaValori_buttonActionPerformed
        email_field.setText("");
        password_field.setText("");
    }//GEN-LAST:event_reimpostaValori_buttonActionPerformed

    private void recuperaCredenziali_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuperaCredenziali_buttonActionPerformed
        this.setVisible(false);
        recuperaCredenziali recovery = new recuperaCredenziali();
        recovery.toFront();
        recovery.setVisible(true);
        recovery.getContentPane().setBackground(new java.awt.Color(198,231,201));
        recovery.setResizable(false);
        recovery.setTitle("Pharmalink - Recupero Credenziali");
        email_field.setText("");
        password_field.setText(""); 
    }//GEN-LAST:event_recuperaCredenziali_buttonActionPerformed

    private void esci_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esci_buttonActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Sei sicuro di voler chiudere l'applicazione?", "Uscita", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_esci_buttonActionPerformed

    private void accedi_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accedi_buttonActionPerformed
            String email = email_field.getText().toLowerCase();
            String password = new String(password_field.getPassword());
            if (email.length()>0 && password.length()>0){
                Statement pst;
                ResultSet rs;
                String farmacista = "farmacista";
                String magazziniere = "magazziniere";
                String fattorino = "fattorino";
                try{
                    String query = "SELECT * FROM utente, contratto WHERE email='" + email + "' AND password='" + password +"'";  
                    pst = connessione.prepareStatement(query);
                    rs  = pst.executeQuery(query);

                    if(!rs.next()){
                        JOptionPane.showMessageDialog(null,"Email o password errata, riprova.", "Errore", JOptionPane.WARNING_MESSAGE);
                        pst.close();
                        rs.close();
                    }
                    // Menù Farmacista
                    if(email.equals(rs.getString("email")) && password.equals(rs.getString("password")) && farmacista.equals(rs.getString("lavoro"))){
                        this.setVisible(false);
                        Farmacista farmacia = new Farmacista();
                        farmacia.setVisible(true);
                        farmacia.toFront();
                        farmacia.setTitle("Pharmalink - Menù Farmacista");
                        farmacia.setResizable(false);
                        farmacia.getContentPane().setBackground(new java.awt.Color(198,231,201));
                        email_field.setText("");
                        password_field.setText("");
                        String id = rs.getString("utente.id");
                        String idContratto = rs.getString("contratto.idContratto");
                        CheckID controllo = new CheckID(id);
                        CheckContratto controllo2 = new CheckContratto(idContratto);
                    }
                    // Menù Magazziniere
                    else if(email.equals(rs.getString("email")) && password.equals(rs.getString("password")) && magazziniere.equals(rs.getString("lavoro"))){
                        this.toBack();
                        this.setVisible(false);
                        Magazziniere magazzino = new Magazziniere();
                        magazzino.getContentPane().setBackground(new java.awt.Color(198,231,201));
                        magazzino.setResizable(false);
                        magazzino.setTitle("Pharmalink - Menù Magazziniere");
                        magazzino.setVisible(true);
                        email_field.setText("");
                        password_field.setText("");
                    }
                    // Menù Fattorino
                    else if(email.equals(rs.getString("email")) && password.equals(rs.getString("password")) && fattorino.equals(rs.getString("lavoro"))){
                        this.toBack();
                        this.setVisible(false);
                        Fattorino corriere = new Fattorino();
                        corriere.getContentPane().setBackground(new java.awt.Color(198,231,201));
                        corriere.setResizable(false);
                        corriere.setTitle("Pharmalink - Menù Fattorino");
                        corriere.setVisible(true);
                        corriere.setVisible(true);
                        email_field.setText("");
                        password_field.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Email o password errata, riprova.", "Errore", JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(ClassNotFoundException | HeadlessException | SQLException  e){
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            else{
                JFrame frame;
                frame = new JFrame("Errore");
                frame.setResizable(false);
                JOptionPane.showMessageDialog(frame,"Campi vuoti in email o password", "Errore", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_accedi_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accedi_button;
    private javax.swing.JTextField email_field;
    private javax.swing.JButton esci_button;
    private javax.swing.JLabel nomeUtente_label;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel password_label;
    private javax.swing.JButton recuperaCredenziali_button;
    private javax.swing.JButton reimpostaValori_button;
    private javax.swing.JLabel titoloLogin;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) throws ClassNotFoundException{
        Login log = new Login();
        log.getContentPane().setBackground(new java.awt.Color(198,231,201));
        log.setVisible(true);
        log.setResizable(false);
        log.setTitle("Pharmalink - Autenticazione");
    }
}


