package Farmacista;

import CredenzialiUtente.CredenzialiUtente;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GestioneOrdini extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public GestioneOrdini() throws ClassNotFoundException{
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tracciaOrdiniButton = new javax.swing.JButton();
        storicoOrdiniButton = new javax.swing.JButton();
        modificaOrdineButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tornaIndietroButton = new javax.swing.JButton();
        confermaRicezioneOrdineButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));

        jPanel1.setBackground(new java.awt.Color(221, 221, 221));

        tracciaOrdiniButton.setBackground(new java.awt.Color(7, 139, 163));
        tracciaOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tracciaOrdiniButton.setForeground(new java.awt.Color(255, 255, 255));
        tracciaOrdiniButton.setText("Traccia Ordini");
        tracciaOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tracciaOrdiniButtonActionPerformed(evt);
            }
        });

        storicoOrdiniButton.setBackground(new java.awt.Color(7, 139, 163));
        storicoOrdiniButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        storicoOrdiniButton.setForeground(new java.awt.Color(255, 255, 255));
        storicoOrdiniButton.setText("Storico ordini");
        storicoOrdiniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storicoOrdiniButtonActionPerformed(evt);
            }
        });

        modificaOrdineButton.setBackground(new java.awt.Color(7, 139, 163));
        modificaOrdineButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modificaOrdineButton.setForeground(new java.awt.Color(255, 255, 255));
        modificaOrdineButton.setText("Modifica Ordine");
        modificaOrdineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaOrdineButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 139, 163));
        jLabel1.setText("Gestione Ordini");

        tornaIndietroButton.setBackground(new java.awt.Color(7, 139, 163));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Annulla");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        confermaRicezioneOrdineButton.setBackground(new java.awt.Color(7, 139, 163));
        confermaRicezioneOrdineButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confermaRicezioneOrdineButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaRicezioneOrdineButton.setText("Conferma Ricezione Ordine ");
        confermaRicezioneOrdineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaRicezioneOrdineButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tornaIndietroButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 85, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(tracciaOrdiniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(storicoOrdiniButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificaOrdineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confermaRicezioneOrdineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tracciaOrdiniButton)
                .addGap(18, 18, 18)
                .addComponent(storicoOrdiniButton)
                .addGap(18, 18, 18)
                .addComponent(modificaOrdineButton)
                .addGap(18, 18, 18)
                .addComponent(confermaRicezioneOrdineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addComponent(tornaIndietroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
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

    private void tornaIndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornaIndietroButtonActionPerformed
        try {
            this.setVisible(false);
            Farmacista farmacista = new Farmacista();
            farmacista.setVisible(true);
            farmacista.setResizable(false);
            farmacista.setTitle("Pharmalink - Menù Farmacista");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void tracciaOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tracciaOrdiniButtonActionPerformed
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
            TracciaOrdini to = new TracciaOrdini();
            to.setVisible(true);
            to.toFront();
            to.setTitle("Pharmalink - Traccia Ordini");
            }
        }
        catch(HeadlessException | SQLException  e){
            Logger.getLogger(GestioneOrdini.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tracciaOrdiniButtonActionPerformed

    private void storicoOrdiniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storicoOrdiniButtonActionPerformed
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
            StoricoOrdini so = new StoricoOrdini();
            so.setVisible(true);
            so.toFront();
            so.setTitle("Pharmalink - Storico Ordini");
            }
        }
        catch(HeadlessException | SQLException  e){
            Logger.getLogger(GestioneOrdini.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_storicoOrdiniButtonActionPerformed

    private void modificaOrdineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaOrdineButtonActionPerformed
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
                ModificaOrdine mo = new ModificaOrdine();
                mo.setVisible(true);
                mo.toFront();
                mo.setTitle("Pharmalink - Modifica Ordine");
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(GestioneOrdini.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_modificaOrdineButtonActionPerformed

    private void confermaRicezioneOrdineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaRicezioneOrdineButtonActionPerformed
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
            ConfermaRicezioneOrdini cro = new ConfermaRicezioneOrdini();
            cro.setVisible(true);
            cro.toFront();
            cro.setTitle("Pharmalink - Conferma Ricezione Ordini");
            }
        }
        catch(HeadlessException | SQLException | ClassNotFoundException e){
            Logger.getLogger(GestioneOrdini.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_confermaRicezioneOrdineButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaRicezioneOrdineButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modificaOrdineButton;
    private javax.swing.JButton storicoOrdiniButton;
    private javax.swing.JButton tornaIndietroButton;
    private javax.swing.JButton tracciaOrdiniButton;
    // End of variables declaration//GEN-END:variables
}
