package Farmacista;

import IndirizzoIP.IndirizzoIP;
import Login.Login;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Farmacista extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public Farmacista() throws ClassNotFoundException {
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
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        logoutButton = new javax.swing.JButton();
        CatalogoButton = new javax.swing.JButton();
        gestioneOrdiniButton = new javax.swing.JButton();
        gestioneContrattoButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutButton.setBackground(new java.awt.Color(204, 0, 0));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        CatalogoButton.setBackground(new java.awt.Color(4, 76, 208));
        CatalogoButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CatalogoButton.setForeground(new java.awt.Color(255, 255, 255));
        CatalogoButton.setText("Catalogo");
        CatalogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatalogoButtonActionPerformed(evt);
            }
        });

        gestioneOrdiniButton.setBackground(new java.awt.Color(4, 76, 208));
        gestioneOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gestioneOrdiniButton.setForeground(new java.awt.Color(255, 255, 255));
        gestioneOrdiniButton.setText("Gestione Ordini");
        gestioneOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestioneOrdiniButtonActionPerformed(evt);
            }
        });

        gestioneContrattoButton.setBackground(new java.awt.Color(4, 76, 208));
        gestioneContrattoButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gestioneContrattoButton.setForeground(new java.awt.Color(255, 255, 255));
        gestioneContrattoButton.setText("Gestione Contratto");
        gestioneContrattoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestioneContrattoButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Menù Farmacista");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(gestioneContrattoButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gestioneOrdiniButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CatalogoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoutButton)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(gestioneContrattoButton)
                .addGap(18, 18, 18)
                .addComponent(CatalogoButton)
                .addGap(18, 18, 18)
                .addComponent(gestioneOrdiniButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                log.getContentPane().setBackground(new java.awt.Color(198,231,201));
                log.toFront();
                log.setResizable(false);
                log.setVisible(true);
                log.setTitle("Pharmalink - Autenticazione");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void gestioneOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestioneOrdiniButtonActionPerformed
        id = CheckID.getID();
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
                GestioneOrdini to = new GestioneOrdini();
                to.setVisible(true);
                to.toFront();
                to.setTitle("Pharmalink - Gestione Ordini");
                to.setResizable(false);
                to.getContentPane().setBackground(new java.awt.Color(198,231,201));
                CheckID controllo = new CheckID(id);
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_gestioneOrdiniButtonActionPerformed

    private void CatalogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatalogoButtonActionPerformed
        id = CheckID.getID();
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
                OrdinaFarmaco mc = new OrdinaFarmaco();
                mc.setVisible(true);
                mc.toFront();
                mc.setTitle("Pharmalink - Ordina farmaco");
                mc.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                mc.getContentPane().setBackground(new java.awt.Color(198,231,201));
                CheckID controllo = new CheckID(id);
            }
        }
        catch(HeadlessException | SQLException  e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CatalogoButtonActionPerformed
    
    private void gestioneContrattoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestioneContrattoButtonActionPerformed
        id = CheckID.getID();
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
                ModificaParametri gcf = new ModificaParametri();
                gcf.setVisible(true);
                gcf.toFront();
                gcf.setTitle("Pharmalink - Gestione Contratto");
                gcf.setResizable(true);
                gcf.getContentPane().setBackground(new java.awt.Color(198,231,201));
                CheckID controllo = new CheckID(id);
            }
        }
        catch(ClassNotFoundException | HeadlessException | SQLException  e){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_gestioneContrattoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CatalogoButton;
    private javax.swing.JButton gestioneContrattoButton;
    private javax.swing.JButton gestioneOrdiniButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JButton logoutButton;
    // End of variables declaration//GEN-END:variables

}
