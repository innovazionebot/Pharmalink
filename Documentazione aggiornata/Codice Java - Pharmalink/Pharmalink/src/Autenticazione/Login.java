package Autenticazione;

import Magazziniere.Magazziniere;
import Fattorino.Fattorino;
import Farmacista.Farmacista;
import CredenzialiUtente.CredenzialiUtente;
import Farmacista.ControlloScorte;
import Farmacista.ControlloStato;
import Farmacista.OrdinePeriodico;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.*;

public class Login extends javax.swing.JFrame {
    private Connection connessione;
    public Login() throws ClassNotFoundException{
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
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titoloLogin = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        nomeUtente_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        accedi_button = new javax.swing.JButton();
        recuperaCredenziali_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(215, 248, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(448, 209));

        jPanel1.setBackground(new java.awt.Color(221, 221, 221));
        jPanel1.setMaximumSize(new java.awt.Dimension(448, 209));
        jPanel1.setMinimumSize(new java.awt.Dimension(448, 209));
        jPanel1.setPreferredSize(new java.awt.Dimension(448, 209));

        titoloLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titoloLogin.setForeground(new java.awt.Color(7, 139, 163));
        titoloLogin.setText("Pharmalink");

        email_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        password_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        nomeUtente_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeUtente_label.setText("Inserire E-mail");

        password_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        password_label.setText("Inserire Password");

        accedi_button.setBackground(new java.awt.Color(7, 139, 163));
        accedi_button.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        accedi_button.setForeground(new java.awt.Color(255, 255, 255));
        accedi_button.setText("Accedi");
        accedi_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accedi_buttonActionPerformed(evt);
            }
        });

        recuperaCredenziali_button.setBackground(new java.awt.Color(7, 139, 163));
        recuperaCredenziali_button.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recuperaCredenziali_button.setForeground(new java.awt.Color(255, 255, 255));
        recuperaCredenziali_button.setText("Recupera credenziali");
        recuperaCredenziali_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuperaCredenziali_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nomeUtente_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_field)
                            .addComponent(email_field)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(recuperaCredenziali_button, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addComponent(accedi_button, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(titoloLogin)
                .addGap(140, 140, 140))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titoloLogin)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeUtente_label)
                    .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_label)
                    .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recuperaCredenziali_button)
                    .addComponent(accedi_button))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recuperaCredenziali_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuperaCredenziali_buttonActionPerformed
        try {
            this.setVisible(false);
            RecuperaCredenziali recovery = new RecuperaCredenziali();
            recovery.toFront();
            recovery.setVisible(true);
            recovery.getContentPane().setBackground(new java.awt.Color(198,231,201));
            recovery.setResizable(false);
            recovery.setTitle("Pharmalink - Recupero Credenziali");
            email_field.setText("");
            password_field.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_recuperaCredenziali_buttonActionPerformed

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
                    JOptionPane.showMessageDialog(null,"Credenziali Errate", "Errore DBMS", JOptionPane.WARNING_MESSAGE);
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
                    email_field.setText("");
                    password_field.setText("");
                    String id = rs.getString("utente.id");
                    String nome = rs.getString("utente.nome");
                    String cognome = rs.getString("utente.cognome");
                    String idContratto = rs.getString("contratto.idContratto");
                    CredenzialiUtente utente = new CredenzialiUtente(id, nome, cognome, idContratto);
                }
                // Menù Magazziniere
                else if(email.equals(rs.getString("email")) && password.equals(rs.getString("password")) && magazziniere.equals(rs.getString("lavoro"))){
                    this.toBack();
                    this.setVisible(false);
                    Magazziniere magazzino = new Magazziniere();
                    magazzino.setResizable(false);
                    magazzino.setTitle("Pharmalink - Menù Magazziniere");
                    magazzino.setVisible(true);
                    email_field.setText("");
                    password_field.setText("");
                    String id = rs.getString("utente.id");
                    String nome = rs.getString("utente.nome");
                    String cognome = rs.getString("utente.cognome");
                    CredenzialiUtente utente = new CredenzialiUtente(id, nome, cognome, "");
                }
                // Menù Fattorino
                else if(email.equals(rs.getString("email")) && password.equals(rs.getString("password")) && fattorino.equals(rs.getString("lavoro"))){
                    this.toBack();
                    this.setVisible(false);
                    Fattorino corriere = new Fattorino();
                    corriere.setResizable(false);
                    corriere.setTitle("Pharmalink - Menù Fattorino");
                    corriere.setVisible(true);
                    corriere.setVisible(true);
                    email_field.setText("");
                    password_field.setText("");
                    String id = rs.getString("utente.id");
                    String nome = rs.getString("utente.nome");
                    String cognome = rs.getString("utente.cognome");
                    CredenzialiUtente utente = new CredenzialiUtente(id, nome, cognome, "");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Email o password errata, riprova.", "Errore credenziali", JOptionPane.WARNING_MESSAGE);
                }
            }
            catch(ClassNotFoundException | HeadlessException | SQLException | InterruptedException  e){
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        else{
            JFrame frame;
            frame = new JFrame("Errore credenziali");
            frame.setResizable(false);
            JOptionPane.showMessageDialog(frame,"Campi vuoti in email o password", "Errore", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_accedi_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accedi_button;
    private javax.swing.JTextField email_field;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomeUtente_label;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel password_label;
    private javax.swing.JButton recuperaCredenziali_button;
    private javax.swing.JLabel titoloLogin;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException, ParseException{
        Login log = new Login();
        log.setVisible(true);
        log.setResizable(false);
        log.setTitle("Pharmalink - Autenticazione");
        OrdinePeriodico op = new OrdinePeriodico();
        Thread.sleep(2000);
        ControlloScorte cs = new ControlloScorte();
        Thread.sleep(2000);
        ControlloStato a = new ControlloStato();
        Thread.sleep(2000);
    }
}


