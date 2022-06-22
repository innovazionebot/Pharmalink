package Farmacista;

import IndirizzoIP.IndirizzoIP;
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
    }

    public ArrayList<Farmaci> contrattoList() throws ClassNotFoundException{
        ArrayList<Farmaci> contrattiList = new ArrayList<>();
        try{
            IndirizzoIP address = new IndirizzoIP();
            String url = "jdbc:mysql://" + address.ip + "/";
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
            Farmaci contratti;
            while(rs.next()){
                contratti = new Farmaci(rs.getString("f.nome"), rs.getString("f.principio"), rs.getString("fc.quantita"), rs.getString("fc.periodo"));
                contrattiList.add(contratti);
            }
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex);
        }
        return contrattiList;
    }

    public void mostra_farmaci() throws ClassNotFoundException{
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaFarmaci = new javax.swing.JTable();
        tornaIndietroButton = new javax.swing.JButton();
        confermaButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));
        setPreferredSize(new java.awt.Dimension(1076, 666));

        tabellaFarmaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Farmaco", "Principio Attivo", "Quantità Attuale", "Periodo Attuale", "Nuova Quantità", "Nuovo Periodo"
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

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Torna al menù principale");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        confermaButton.setBackground(new java.awt.Color(0, 204, 0));
        confermaButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
                .addComponent(tornaIndietroButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tornaIndietroButton))
                .addContainerGap())
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
                gcf.setTitle("Pharmalink - Menù Farmacista");
                gcf.setResizable(false);
                gcf.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed
    
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
        ModificaParametri gm = new ModificaParametri();
        gm.setVisible(true);
        gm.toFront();
        gm.setTitle("Pharmalink - Modifica Parametri");
        gm.setResizable(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Nessun farmaco selezionato");
            Logger.getLogger(ModificaParametri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void tabellaFarmaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaFarmaciMouseClicked

    }//GEN-LAST:event_tabellaFarmaciMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabellaFarmaci;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
