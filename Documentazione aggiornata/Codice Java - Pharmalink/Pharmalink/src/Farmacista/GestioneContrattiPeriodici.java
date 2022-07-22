package Farmacista;

import CredenzialiUtente.CredenzialiUtente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestioneContrattiPeriodici extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idContratto;
    public GestioneContrattiPeriodici() throws ClassNotFoundException, SQLException {
        initComponents();
        mostra_farmaci();
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaFarmaci = new javax.swing.JTable();
        confermaButton = new javax.swing.JButton();
        annullaButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));

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
        jScrollPane3.setViewportView(tabellaFarmaci);

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

        annullaButton.setBackground(new java.awt.Color(7, 139, 163));
        annullaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        annullaButton.setForeground(new java.awt.Color(255, 255, 255));
        annullaButton.setText("Annulla");
        annullaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(annullaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annullaButton))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            Logger.getLogger(GestioneContrattiPeriodici.class.getName()).log(Level.SEVERE, null, ex);
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
                }
                else if((Integer.parseInt(quantita2)==Integer.parseInt(quantita)) && (Integer.parseInt(periodo2)==Integer.parseInt(periodo))){
                    JOptionPane.showMessageDialog(null,"Attenzione!\nQuantità o periodo sono rimasti invariati.", "Segnalazione errore", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Errore", "Segnalazione errore", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Farmaci ordinati con successo.", "Completamento ordine", JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
        GestioneContrattiPeriodici gm = new GestioneContrattiPeriodici();
        gm.setVisible(true);
        gm.toFront();
        gm.setTitle("Pharmalink - Modifica Parametri");
        gm.setResizable(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Nessun farmaco selezionato");
            Logger.getLogger(GestioneContrattiPeriodici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullaButton;
    private javax.swing.JButton confermaButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabellaFarmaci;
    // End of variables declaration//GEN-END:variables
}
