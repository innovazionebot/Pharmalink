package Magazziniere;

import Magazziniere.*;
import IndirizzoIP.IndirizzoIP;
import java.awt.Insets;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SupervisionaOrdini extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public SupervisionaOrdini() throws ClassNotFoundException {
        initComponents();
        mostra_ordini();
        noteTextArea.setLineWrap(true);
        noteTextArea.setSize(232, 92);
        noteTextArea.setMargin(new Insets(10,5,10,5));
    }
    public ArrayList<Ordini> errOrdineList() throws ClassNotFoundException{
        ArrayList<Ordini> ordiniList = new ArrayList<>();
        try{
            IndirizzoIP address = new IndirizzoIP();
            String url = "jdbc:mysql://" + address.ip + "/";
            String dbName = "pharmalinkazienda";
            String driver = "com.mysql.cj.jdbc.Driver";
            String username = "root";
            String password = "";
            Class.forName(driver);
            this.connessione = DriverManager.getConnection(url+dbName, username, password);
            id = CheckIDMagazziniere.getID();
            String query = "SELECT o.idOrdine, o.dataOrdine, o.dataConsegna, o.stato, o.note, u.nome, u.cognome FROM ordine o INNER JOIN utente u ON o.idUtente = u.id WHERE u.lavoro = 'farmacista' AND o.stato='Errore'";
            Statement st = connessione.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            Ordini ordini;
            while(rs.next()){
                ordini = new Ordini(rs.getString("o.idOrdine"), rs.getString("o.dataOrdine"), rs.getString("o.dataConsegna"), rs.getString("o.stato"), rs.getString("u.nome"), rs.getString("u.cognome"), rs.getString("o.note"));
                ordiniList.add(ordini);
            }      
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex);
        }
        return ordiniList;
    }

    public void mostra_ordini() throws ClassNotFoundException{
        ArrayList<Ordini> ordini = errOrdineList();
        DefaultTableModel model = (DefaultTableModel) tabellaOrdini.getModel();
        Object[] righe = new Object[6];
        for(int i=0;i<ordini.size(); i++){
            righe[0] = ordini.get(i).getIdOrdine();
            righe[1] = ordini.get(i).getDataOrdine();
            righe[2] = ordini.get(i).getDataConsegna();
            righe[3] = ordini.get(i).getStato();
            righe[4] = ordini.get(i).getNome();
            righe[5] = ordini.get(i).getCognome();
            model.addRow(righe);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaOrdini = new javax.swing.JTable();
        tornaIndietroButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        noteTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        confermaOrdineButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabellaOrdini.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ordine", "Data Ordine", "Data Consegna", "Stato Consegna", "Nome", "Cognome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabellaOrdini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaOrdiniMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabellaOrdini);

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Torna al menù principale");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        noteTextArea.setEditable(false);
        noteTextArea.setColumns(20);
        noteTextArea.setRows(5);
        jScrollPane2.setViewportView(noteTextArea);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Note consegna");

        confermaOrdineButton.setBackground(new java.awt.Color(0, 204, 51));
        confermaOrdineButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        confermaOrdineButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaOrdineButton.setText("Correggi Ordine");
        confermaOrdineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaOrdineButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tornaIndietroButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confermaOrdineButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tornaIndietroButton)
                    .addComponent(confermaOrdineButton))
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
                Magazziniere gcf = new Magazziniere();
                gcf.toFront();
                gcf.setVisible(true);
                gcf.setTitle("Pharmalink - Menù Magazziniere");
                gcf.setResizable(false);
                gcf.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (ClassNotFoundException | InterruptedException ex) {
                Logger.getLogger(SupervisionaOrdini.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void confermaOrdineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaOrdineButtonActionPerformed
        PreparedStatement pst;
        try{
            String idOrdine = "";
            for(int i=0; i<tabellaOrdini.getRowCount(); i++){
                if(tabellaOrdini.isRowSelected(i)){
                    idOrdine = (tabellaOrdini.getModel().getValueAt(i, 0).toString());
                    String query = "UPDATE ordine SET stato = \"Consegnato\", note = \"Risolte problematiche inerenti all'ordine\" WHERE idOrdine = '"+idOrdine+"'";
                    pst = connessione.prepareStatement(query);
                    pst.executeUpdate();
                    String query2 = "UPDATE ordine SET ordineCaricato = \"Si\" WHERE idOrdine = '"+idOrdine+"'";
                    PreparedStatement pst2;
                    pst2 = connessione.prepareStatement(query2);
                    pst2.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null,"Modifiche effettuate correttamente.", "Notifica completamento modifiche", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            SupervisionaOrdini so = new SupervisionaOrdini();
            so.setVisible(true);
            so.toFront();
            so.setTitle("Pharmalink - Supervisiona Ordini");
            so.setResizable(false);
        }
        catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(SupervisionaOrdini.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_confermaOrdineButtonActionPerformed

    private void tabellaOrdiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaOrdiniMouseClicked
        ResultSet rs;
        Statement st;
        try{
            String note = "";
            int riga = tabellaOrdini.getSelectedRow();
            String idOrdine = (tabellaOrdini.getModel().getValueAt(riga, 0).toString());
            String query = "SELECT note FROM ordine WHERE idOrdine = '"+idOrdine+"' AND stato = \"Errore\"";
            st = connessione.prepareStatement(query);
            rs = st.executeQuery(query);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Errore durante la comunicazione con il DBMS", "Errore", JOptionPane.WARNING_MESSAGE);
                st.close();
                rs.close();
            }
            else{
                note = rs.getString("note");
                for(int i=0; i<tabellaOrdini.getRowCount(); i++){
                    if(tabellaOrdini.isRowSelected(i)){
                        noteTextArea.setText(note);
                    }
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(SupervisionaOrdini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabellaOrdiniMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaOrdineButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea noteTextArea;
    private javax.swing.JTable tabellaOrdini;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
