package Magazziniere;

import Autenticazione.Login;
import CredenzialiUtente.CredenzialiUtente;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Magazziniere extends javax.swing.JFrame{
    private Connection connessione;
    private String id;
    public Magazziniere() throws ClassNotFoundException, InterruptedException{
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
        try{
            String query = "SELECT COUNT(idOrdine) from ordine WHERE stato = \"Errore\"";
            Statement st = connessione.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                st.close();
                rs.close();
            }
            else{
                String numero = rs.getString("COUNT(idOrdine)");
                if(Integer.parseInt(numero) >=1){
                    ImageIcon icona = new ImageIcon("C:\\Users\\salva\\Documents\\NetBeansProjects\\Pharmalink\\src\\Magazziniere\\icon.png");
                    JLabel avvertenza = new JLabel (icona);
                    avvertenza.setBounds(320,70, 50 ,30);
                    avvertenza.setSize(50, 50);
                    this.add(avvertenza);
                }
            }
        }
        catch(HeadlessException | SQLException e){
            Logger.getLogger(Magazziniere.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        supervisionaOrdiniButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(221, 221, 221));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 139, 163));
        jLabel2.setText("Menù Magazziniere");

        logoutButton.setBackground(new java.awt.Color(7, 139, 163));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        supervisionaOrdiniButton.setBackground(new java.awt.Color(7, 139, 163));
        supervisionaOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        supervisionaOrdiniButton.setForeground(new java.awt.Color(255, 255, 255));
        supervisionaOrdiniButton.setText("Supervisiona ordini");
        supervisionaOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supervisionaOrdiniButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoutButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(supervisionaOrdiniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(supervisionaOrdiniButton)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        try{    
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
            login.setResizable(false);
            login.setTitle("Pharmalink - Autenticazione");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Magazziniere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void supervisionaOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supervisionaOrdiniButtonActionPerformed
        id = CredenzialiUtente.getId();
        try{
            this.setVisible(false);
            SupervisionaOrdini so = new SupervisionaOrdini();
            so.setVisible(true);
            so.toFront();
            so.setTitle("Pharmalink - Supervisiona Ordini");
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            Logger.getLogger(Magazziniere.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_supervisionaOrdiniButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton supervisionaOrdiniButton;
    // End of variables declaration//GEN-END:variables
}
