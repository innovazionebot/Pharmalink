package Magazziniere;

import IndirizzoIP.IndirizzoIP;
import Login.Login;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import Magazziniere.CheckIDMagazziniere;
import java.awt.*;

public class Magazziniere extends javax.swing.JFrame{
    private Connection connessione;
    private String id;
    public Magazziniere() throws ClassNotFoundException, InterruptedException{
        this.getContentPane().setBackground(new java.awt.Color(198,231,201));
        IndirizzoIP address = new IndirizzoIP();
        String url = "jdbc:mysql://" + address.ip + "/";
        String dbName = "pharmalinkazienda";
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "";
        try{
            Class.forName(driver);
            this.connessione = DriverManager.getConnection(url+dbName, username, password);
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        try{
            String idOrdine = "";
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
                    ImageIcon icona = new ImageIcon("C:\\Users\\salva\\Documents\\NetBeansProjects\\Pharma\\src\\Magazziniere\\icon.png");
                    JLabel avvertenza = new JLabel (icona);
                    avvertenza.setBounds(400,200, 100,30);
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

        logoutButton = new javax.swing.JButton();
        supervisionaOrdiniButton = new javax.swing.JButton();
        aggiungiFarmacoButton = new javax.swing.JButton();
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

        supervisionaOrdiniButton.setBackground(new java.awt.Color(4, 76, 208));
        supervisionaOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        supervisionaOrdiniButton.setForeground(new java.awt.Color(255, 255, 255));
        supervisionaOrdiniButton.setText("Supervisiona Ordini");
        supervisionaOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supervisionaOrdiniButtonActionPerformed(evt);
            }
        });

        aggiungiFarmacoButton.setBackground(new java.awt.Color(4, 76, 208));
        aggiungiFarmacoButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        aggiungiFarmacoButton.setForeground(new java.awt.Color(255, 255, 255));
        aggiungiFarmacoButton.setText("Aggiungi Farmaco");
        aggiungiFarmacoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiFarmacoButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Menù Magazziniere");

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
                    .addComponent(supervisionaOrdiniButton)
                    .addComponent(aggiungiFarmacoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(aggiungiFarmacoButton)
                .addGap(55, 55, 55)
                .addComponent(supervisionaOrdiniButton)
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
                //log.getContentPanesupervisionaOrdiniButton().setBackground(new java.awt.Color(198,231,201));
                log.toFront();
                log.setResizable(false);
                log.setVisible(true);
                log.setTitle("Pharmalink - Autenticazione");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Magazziniere.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void supervisionaOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supervisionaOrdiniButtonActionPerformed
        id = CheckIDMagazziniere.getID();
        try{
            this.setVisible(false);
            SupervisionaOrdini so = new SupervisionaOrdini();
            so.setVisible(true);
            so.toFront();
            so.setTitle("Pharmalink - Supervisiona Ordini");
            so.getContentPane().setBackground(new java.awt.Color(198,231,201));
        }
        catch(HeadlessException | ClassNotFoundException e){
            Logger.getLogger(Magazziniere.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_supervisionaOrdiniButtonActionPerformed

    private void aggiungiFarmacoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiFarmacoButtonActionPerformed
        id = CheckIDMagazziniere.getID();
        try{
            this.setVisible(false);
            AggiungiFarmaco af = new AggiungiFarmaco();
            af.setVisible(true);
            af.toFront();
            af.setTitle("Pharmalink - Aggiungi Farmaco");
            af.getContentPane().setBackground(new java.awt.Color(198,231,201));
        }
        catch(HeadlessException | ClassNotFoundException ex){
            Logger.getLogger(Magazziniere.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_aggiungiFarmacoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiungiFarmacoButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton supervisionaOrdiniButton;
    // End of variables declaration//GEN-END:variables
}
