package Farmacista;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ModificaParametri extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idContratto;
    public ModificaParametri() throws ClassNotFoundException {
        initComponents();
        mostra_farmaci();
        periodicitaField.setVisible(true);
        quantitaFarmacoField.setVisible(true);
    }

    public ArrayList<Farmaci> farmacoList() throws ClassNotFoundException{
        ArrayList<Farmaci> farmaciList = new ArrayList<>();
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
            //String query = "SELECT f.nomeFarmaco, f.principioAttivo, f.dataScadenza, f.idUtente, f.idContratto, f.quantitaFarmaco, u.id FROM farmaco f INNER JOIN contratto c ON c.idContratto = f.idContratto INNER JOIN utente u ON u.id = f.idUtente AND u.id='"+id+"'";
            String query = "SELECT f.nome, f.principio, fc.quantita, fc.periodo, fc.idContratto, u.id FROM farmacocontratto fc INNER JOIN contratto c ON c.idContratto = fc.idContratto INNER JOIN farmaco f ON f.idFarmaco = fc.idFarmaco INNER JOIN utente u ON u.id='"+id+"' AND c.idContratto = '"+idContratto+"'";
            Statement st = connessione.createStatement();
            ResultSet rs = st.executeQuery(query);
            Farmaci farmaci;
            while(rs.next()){
                farmaci = new Farmaci(rs.getString("f.nome"), rs.getString("f.principio"), rs.getString("fc.quantita"), rs.getString("fc.periodo"));
                farmaciList.add(farmaci);
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
        ArrayList<Farmaci> farmaci = farmacoList();
        DefaultTableModel model = (DefaultTableModel) tabellaFarmaci.getModel();
        Object[] righe = new Object[4];
        for(int i=0;i<farmaci.size(); i++){
            righe[0] = farmaci.get(i).getNomeFarmaco();
            righe[1] = farmaci.get(i).getPrincipio();
            righe[2] = farmaci.get(i).getQuantita();
            righe[3] = farmaci.get(i).getPeriodo();
            model.addRow(righe);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaFarmaci = new javax.swing.JTable();
        tornaIndietroButton = new javax.swing.JButton();
        resettaCampi = new javax.swing.JButton();
        confermaButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nomeFarmacoField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        quantitaFarmacoField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        periodicitaField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        principioField = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabellaFarmaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nomeFarmaco", "principioAttivo", "quantitaFarmaco", "periodo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane3.setViewportView(tabellaFarmaci);
        if (tabellaFarmaci.getColumnModel().getColumnCount() > 0) {
            tabellaFarmaci.getColumnModel().getColumn(0).setResizable(false);
            tabellaFarmaci.getColumnModel().getColumn(1).setResizable(false);
            tabellaFarmaci.getColumnModel().getColumn(2).setResizable(false);
            tabellaFarmaci.getColumnModel().getColumn(3).setResizable(false);
        }

        tornaIndietroButton.setText("Torna indietro");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
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

        quantitaFarmacoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitaFarmacoFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Periodicità");

        periodicitaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodicitaFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Principio");

        principioField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        principioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principioFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confermaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(tornaIndietroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(resettaCampi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantitaFarmacoField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(principioField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomeFarmacoField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(periodicitaField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeFarmacoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(principioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantitaFarmacoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(periodicitaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tornaIndietroButton)
                            .addComponent(resettaCampi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tornaIndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornaIndietroButtonActionPerformed
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
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void resettaCampiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resettaCampiActionPerformed
        nomeFarmacoField.setText("");
        principioField.setText("");
        quantitaFarmacoField.setText("");
        periodicitaField.setText("");
    }//GEN-LAST:event_resettaCampiActionPerformed
    
    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        try {
        int righe = tabellaFarmaci.getSelectedRow();
        String nomeFarmacoSelezionato = (tabellaFarmaci.getModel().getValueAt(righe, 0).toString());
        String query = "UPDATE farmacocontratto fc INNER JOIN farmaco f ON f.idFarmaco = fc.idFarmaco AND f.nome = '"+nomeFarmacoSelezionato+"' SET quantita = ?, periodo = ?";
        PreparedStatement pst;
        pst = connessione.prepareStatement(query);
        pst.setString(1, quantitaFarmacoField.getText());
        pst.setString(2, periodicitaField.getText());
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tabellaFarmaci.getModel();
        model.setRowCount(0);
        mostra_farmaci();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Nessun farmaco selezionato");
            Logger.getLogger(ModificaParametri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void nomeFarmacoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFarmacoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFarmacoFieldActionPerformed

    private void quantitaFarmacoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitaFarmacoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitaFarmacoFieldActionPerformed

    private void tabellaFarmaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaFarmaciMouseClicked
        int i = tabellaFarmaci.getSelectedRow();
        TableModel model = tabellaFarmaci.getModel();
        nomeFarmacoField.setText(model.getValueAt(i, 0).toString());
        principioField.setText(model.getValueAt(i, 1).toString());
        quantitaFarmacoField.setText(model.getValueAt(i, 2).toString());
        periodicitaField.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_tabellaFarmaciMouseClicked

    private void periodicitaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodicitaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_periodicitaFieldActionPerformed

    private void principioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_principioFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField nomeFarmacoField;
    private javax.swing.JTextField periodicitaField;
    private javax.swing.JTextField principioField;
    private javax.swing.JTextField quantitaFarmacoField;
    private javax.swing.JButton resettaCampi;
    private javax.swing.JTable tabellaFarmaci;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
