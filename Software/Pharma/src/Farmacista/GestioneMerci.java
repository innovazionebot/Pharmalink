package Farmacista;

import Login.Login;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GestioneMerci extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idContratto;
    public GestioneMerci() throws ClassNotFoundException {
        initComponents();
        mostra_farmaci();
        quantitaField.setEditable(true);
        scadenzaField.setEditable(false);
        nomeFarmacoField.setEditable(false);
        principioField.setEditable(false);
    }
    
    public ArrayList<Catalogo> farmacoList() throws ClassNotFoundException{
        ArrayList<Catalogo> farmaciList = new ArrayList<>();
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "pharmalinkazienda";
            String driver = "com.mysql.cj.jdbc.Driver";
            String username = "root";
            String password = "";
            Class.forName(driver);
            this.connessione = DriverManager.getConnection(url+dbName, username, password);
            id = CheckID.getID();
            idContratto = CheckContratto.getID();
            String query = "SELECT nome, principio, scadenza, quantita FROM farmaco";
            Statement st = connessione.createStatement();
            ResultSet rs = st.executeQuery(query);
            Catalogo catalogo;
            while(rs.next()){
                catalogo = new Catalogo(rs.getString("nome"), rs.getString("principio"), rs.getString("scadenza"), rs.getString("quantita"));
                farmaciList.add(catalogo);
            }
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex);
        }
        return farmaciList;
    }

    public void mostra_farmaci() throws ClassNotFoundException{
        ArrayList<Catalogo> farmaci = farmacoList();
        DefaultTableModel model = (DefaultTableModel) tabellaFarmaci.getModel();
        Object[] righe = new Object[4];
        for(int i=0;i<farmaci.size(); i++){
            righe[0] = farmaci.get(i).getNomeFarmaco();
            righe[1] = farmaci.get(i).getPrincipio();
            righe[2] = farmaci.get(i).getScadenza();
            righe[3] = farmaci.get(i).getQuantita();
            model.addRow(righe);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaFarmaci = new javax.swing.JTable();
        confermaButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nomeFarmacoField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        scadenzaField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        principioField = new javax.swing.JTextField();
        resettaCampi = new javax.swing.JButton();
        quantitaField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitButton.setBackground(new java.awt.Color(204, 0, 0));
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("Torna al menù principale");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        tabellaFarmaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Principio", "Scadenza", "Quantita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabellaFarmaci.getTableHeader().setReorderingAllowed(false);
        tabellaFarmaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaFarmaciMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabellaFarmaci);

        confermaButton.setBackground(new java.awt.Color(0, 204, 0));
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Conferma");
        confermaButton.setMinimumSize(new java.awt.Dimension(104, 28));
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nome farmaco");

        nomeFarmacoField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nomeFarmacoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFarmacoFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Quantità");

        scadenzaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scadenzaFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Scadenza");

        principioField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        principioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principioFieldActionPerformed(evt);
            }
        });

        resettaCampi.setText("Reset");
        resettaCampi.setMaximumSize(new java.awt.Dimension(104, 28));
        resettaCampi.setMinimumSize(new java.awt.Dimension(104, 28));
        resettaCampi.setPreferredSize(new java.awt.Dimension(104, 28));
        resettaCampi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resettaCampiActionPerformed(evt);
            }
        });

        quantitaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitaFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Principio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quantitaField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nomeFarmacoField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scadenzaField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(principioField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(resettaCampi, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(confermaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeFarmacoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(principioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scadenzaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(quantitaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exitButton)
                            .addComponent(resettaCampi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        JFrame frame;
        frame = new JFrame("Uscita");
        frame.setResizable(false);
        if (JOptionPane.showConfirmDialog(frame, "Sei sicuro di voler abbandonare la pagina?", "Avviso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION){
            try {
                this.toBack();
                this.setVisible(false);
                Farmacista gcf = new Farmacista();
                gcf.toFront();
                gcf.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        id = CheckID.getID();
        ResultSet rs;
        PreparedStatement pst1, pst2, pst3, pst4;
        Statement st;
        try{
            int righe = tabellaFarmaci.getSelectedRow();
            String nomeFarmaco = (tabellaFarmaci.getModel().getValueAt(righe, 0).toString());
            String quantitaScelta = quantitaField.getText();
            String q = "SELECT f.idFarmaco, o.idOrdine from farmaco f, ordine o WHERE f.nome = '"+nomeFarmaco+"'";
            st = connessione.prepareStatement(q);
            rs = st.executeQuery(q);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                st.close();
                rs.close();
            }
            else{
                String idFarmaco = rs.getString("f.idFarmaco");
                String idOrdine = rs.getString("o.idOrdine");
                String ordine = "INSERT INTO ordine(idUtente, dataConsegna, stato, note) VALUES ('"+id+"', DATE_ADD(NOW(), INTERVAL 7 DAY), \"In preparazione\", \"Nessun errore\")";
                pst1 = connessione.prepareStatement(ordine);
                pst1.executeUpdate();
                
                
                
                
                
                String quantita = "INSERT INTO farmacoordine(idFarmaco, idOrdine, quantita) VALUES ('"+idFarmaco+"', '"+idOrdine+"', '"+quantitaScelta+"')";
                pst2 = connessione.prepareStatement(quantita);  
                pst2.executeUpdate();
                //String completa = "ALTER TABLE farmaco SET quantita = quantita - "+quantitaScelta+"'";
                String completa = "UPDATE farmaco SET quantita = quantita - '"+quantitaScelta+"' WHERE idFarmaco = '"+idFarmaco+"'";
                pst3 = connessione.prepareStatement(completa);
                pst3.executeUpdate();
                JOptionPane.showMessageDialog(null,"Ordine effettuato con successo.", "Completamento ordine", JOptionPane.PLAIN_MESSAGE);
                DefaultTableModel model = (DefaultTableModel)tabellaFarmaci.getModel();
                model.setRowCount(0);
                mostra_farmaci();
            }
        }
        catch(HeadlessException | SQLException  e){
            Logger.getLogger(GestioneMerci.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestioneMerci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void resettaCampiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resettaCampiActionPerformed
        nomeFarmacoField.setText("");
        principioField.setText("");
        scadenzaField.setText("");
        quantitaField.setText("");
    }//GEN-LAST:event_resettaCampiActionPerformed

    private void quantitaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitaFieldActionPerformed

    private void tabellaFarmaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaFarmaciMouseClicked
        int i = tabellaFarmaci.getSelectedRow();
        TableModel model = tabellaFarmaci.getModel();
        nomeFarmacoField.setText(model.getValueAt(i, 0).toString());
        principioField.setText(model.getValueAt(i, 1).toString());
        scadenzaField.setText(model.getValueAt(i, 2).toString());
    }//GEN-LAST:event_tabellaFarmaciMouseClicked

    private void scadenzaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scadenzaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scadenzaFieldActionPerformed

    private void principioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_principioFieldActionPerformed

    private void nomeFarmacoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFarmacoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFarmacoFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeFarmacoField;
    private javax.swing.JTextField principioField;
    private javax.swing.JTextField quantitaField;
    private javax.swing.JButton resettaCampi;
    private javax.swing.JTextField scadenzaField;
    private javax.swing.JTable tabellaFarmaci;
    // End of variables declaration//GEN-END:variables
}
