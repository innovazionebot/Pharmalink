package Fattorino;

import CredenzialiUtente.CredenzialiUtente;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FirmaConsegna extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public FirmaConsegna() throws ClassNotFoundException {
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
        annullaButton = new javax.swing.JButton();
        confermaButton = new javax.swing.JButton();
        nomeUtente_label = new javax.swing.JLabel();
        titoloLogin = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        password_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(221, 221, 221));

        annullaButton.setBackground(new java.awt.Color(7, 139, 163));
        annullaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        annullaButton.setForeground(new java.awt.Color(255, 255, 255));
        annullaButton.setText("Annulla");
        annullaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButtonActionPerformed(evt);
            }
        });

        confermaButton.setBackground(new java.awt.Color(7, 139, 163));
        confermaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Conferma");
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });

        nomeUtente_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeUtente_label.setText("Inserire E-mail");

        titoloLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titoloLogin.setForeground(new java.awt.Color(7, 139, 163));
        titoloLogin.setText("Firma Consegna");

        email_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        password_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        password_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        password_label.setText("Inserire Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(titoloLogin)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(annullaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confermaButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(password_label)
                        .addGap(18, 18, 18)
                        .addComponent(password_field))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nomeUtente_label, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(email_field)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titoloLogin)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeUtente_label)
                    .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annullaButton)
                    .addComponent(confermaButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annullaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaButtonActionPerformed
        try {
            this.setVisible(false);
            Fattorino fattorino = new Fattorino();
            fattorino.setVisible(true);
            fattorino.setResizable(false);
            fattorino.setTitle("Pharmalink - Menù Fattorino");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(FirmaConsegna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_annullaButtonActionPerformed

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        ResultSet rs;
        Statement st;
        PreparedStatement pst, pst2;
        try{
            String email = email_field.getText().toLowerCase();
            String password = new String(password_field.getPassword());
            String idOrdinePC = IDOrdine_PC.getIdOrdine();
            System.out.println(idOrdinePC);
            LocalDate dataSistema = LocalDate.now();
            String query = "SELECT u.email, u.password, o.idOrdine FROM utente u INNER JOIN ordine o ON u.id = o.idUtente AND o.stato = \"In consegna\" AND o.idOrdine = '"+idOrdinePC+"' AND o.dataConsegna = '"+dataSistema+"'";
            st = connessione.prepareStatement(query);
            rs = st.executeQuery(query);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Errore durante la fase di firma", "Errore", JOptionPane.WARNING_MESSAGE);
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
                    id = CredenzialiUtente.getId();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullaButton;
    private javax.swing.JButton confermaButton;
    private javax.swing.JTextField email_field;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomeUtente_label;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel password_label;
    private javax.swing.JLabel titoloLogin;
    // End of variables declaration//GEN-END:variables
}
