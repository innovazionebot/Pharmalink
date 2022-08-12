package Farmacista;

import CredenzialiUtente.CredenzialiUtente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ModificaParametri extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idContratto;
    public ModificaParametri() throws ClassNotFoundException, SQLException {
        initComponents();
        mostra_farmaci();
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
    }

    public ArrayList<Farmaci> contrattoList() throws ClassNotFoundException, SQLException{
        ArrayList<Farmaci> contrattiList = new ArrayList<>();
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
        id = CredenzialiUtente.getId();
        idContratto = CredenzialiUtente.getIdContratto();
        String query = "SELECT f.nome, f.principio, fc.quantita, fc.periodo, fc.idContratto, u.id FROM farmacocontratto fc INNER JOIN contratto c ON c.idContratto = fc.idContratto INNER JOIN farmaco f ON f.idFarmaco = fc.idFarmaco INNER JOIN utente u ON u.id='"+id+"' AND c.idContratto = '"+idContratto+"'";
        Statement st = connessione.createStatement();
        ResultSet rs = st.executeQuery(query);
        Farmaci contratti;
        while(rs.next()){
            contratti = new Farmaci(rs.getString("f.nome"), rs.getString("f.principio"), rs.getString("fc.quantita"), rs.getString("fc.periodo"));
            contrattiList.add(contratti);
        }
        return contrattiList;
    }

    public void mostra_farmaci() throws ClassNotFoundException, SQLException{
        ArrayList<Farmaci> farmaci = contrattoList();
        DefaultTableModel model = (DefaultTableModel) tabellaFarmaci.getModel();
        Object[] righe = new Object[4];
        for(int i=0;i<farmaci.size(); i++){
            righe[0] = farmaci.get(i).getNomeFarmaco();
            righe[1] = farmaci.get(i).getPrincipio();
            righe[2] = farmaci.get(i).getQuantita();
            righe[3] = farmaci.get(i).getPeriodo();
            model.addRow(righe);
        }
        if(farmaci.isEmpty())
            jLabel1.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaFarmaci = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        annullaButton = new javax.swing.JButton();
        confermaButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));
        setPreferredSize(new java.awt.Dimension(852, 285));
        setResizable(false);

        tabellaFarmaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome farmaco", "Principio attivo", "Quantità attuale", "Periodo attuale", "Quantità nuova", "Periodo nuovo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Campi non compilati");
        jLabel2.setVisible(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Nessuna riga selezionata");
        jLabel1.setVisible(false);

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
        confermaButton.setText("Conferma Modifiche");
        confermaButton.setMinimumSize(new java.awt.Dimension(104, 28));
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(annullaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(annullaButton)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annullaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaButtonActionPerformed
        try{    
            this.setVisible(false);
            Farmacista farmacista = new Farmacista();
            farmacista.setVisible(true);
            farmacista.setResizable(false);
            farmacista.setTitle("Pharmalink - Menù Farmacista");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(ModificaParametri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_annullaButtonActionPerformed
    
    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        PreparedStatement pst;
        try {
        int righe = tabellaFarmaci.getSelectedRow();
        String nomeFarmacoSelezionato = (tabellaFarmaci.getModel().getValueAt(righe, 0).toString());
        String quantita = (tabellaFarmaci.getModel().getValueAt(righe, 2).toString());
        String periodo = (tabellaFarmaci.getModel().getValueAt(righe, 3).toString());
        String quantita2 = "", periodo2 = "";
        for (int i=0; i<tabellaFarmaci.getRowCount(); i++){
            if(tabellaFarmaci.isRowSelected(i)){
                quantita2 = (tabellaFarmaci.getModel().getValueAt(i, 4).toString());
                periodo2 = (tabellaFarmaci.getModel().getValueAt(righe, 5).toString());
                if((Integer.parseInt(quantita2)<Integer.parseInt(quantita)) || (Integer.parseInt(periodo2)<Integer.parseInt(periodo))){
                    String query = "UPDATE farmacocontratto fc INNER JOIN farmaco f ON f.idFarmaco = fc.idFarmaco AND f.nome = '"+nomeFarmacoSelezionato+"' SET fc.quantita = ?, fc.periodo = ?";
                    pst = connessione.prepareStatement(query);
                    pst.setString(1, quantita2);
                    pst.setString(2, periodo2);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Modifiche effettuate correttamente", "Completamento ordine", JOptionPane.WARNING_MESSAGE);
                }
                else if((Integer.parseInt(quantita2)==Integer.parseInt(quantita)) && (Integer.parseInt(periodo2)==Integer.parseInt(periodo))){
                    JOptionPane.showMessageDialog(null,"Attenzione!\nQuantità o periodo sono rimasti invariati.", "Segnalazione errore", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Hai scelto una quantità superiore rispetto a quella predefinita, riprova.", "Segnalazione errore", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        this.setVisible(false);
        ModificaParametri gm = new ModificaParametri();
        gm.setVisible(true);
        gm.toFront();
        gm.setTitle("Pharmalink - Gestione Contratti Periodici");
        gm.setResizable(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Nessun farmaco selezionato");
            Logger.getLogger(ModificaParametri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void tabellaFarmaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaFarmaciMouseClicked
        for(int i=0; i<tabellaFarmaci.getRowCount();i++){
            if(tabellaFarmaci.isRowSelected(i)){
                jLabel1.setVisible(false);
                if(tabellaFarmaci.getModel().getValueAt(i, 4)==null && tabellaFarmaci.getModel().getValueAt(i, 5)==null)
                    jLabel2.setVisible(true);
                else
                    jLabel2.setVisible(false);
            }
        }
    }//GEN-LAST:event_tabellaFarmaciMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullaButton;
    private javax.swing.JButton confermaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabellaFarmaci;
    // End of variables declaration//GEN-END:variables
}
