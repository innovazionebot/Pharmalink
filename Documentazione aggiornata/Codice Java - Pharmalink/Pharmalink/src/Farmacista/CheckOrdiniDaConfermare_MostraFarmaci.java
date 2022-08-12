package Farmacista;
import CredenzialiUtente.CredenzialiUtente;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.table.DefaultTableModel;

public class CheckOrdiniDaConfermare_MostraFarmaci extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idOrdine;
    public CheckOrdiniDaConfermare_MostraFarmaci() throws ClassNotFoundException, SQLException {
        initComponents();
        mostra_check2();
    }
    
    public ArrayList<CheckOrdiniDaConferma_Farmaci> check2List() throws ClassNotFoundException, SQLException{
        ArrayList<CheckOrdiniDaConferma_Farmaci> checks2List = new ArrayList<>();
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
        idOrdine = ID_Ordine.getID();
        System.out.println(idOrdine);
        String query = "SELECT f.nome, f.principio, f.scadenza, fo.quantita, fo.idFarmaco, o.dataConsegna FROM farmaco f INNER JOIN farmacoordine fo ON f.idFarmaco = fo.idFarmaco INNER JOIN ordine o ON o.idOrdine = fo.idOrdine INNER JOIN utente u ON u.id = o.idUtente WHERE u.id = '"+id+"' AND o.stato = \"Consegnato\" AND o.idOrdine = '"+idOrdine+"' AND o.ordineCaricato = \"No\"";
        Statement st = connessione.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        CheckOrdiniDaConferma_Farmaci check2;
        while(rs.next()){
            check2 = new CheckOrdiniDaConferma_Farmaci(rs.getString("fo.idFarmaco"), rs.getString("f.nome"), rs.getString("f.principio"), rs.getString("f.scadenza"), rs.getString("fo.quantita"));
            checks2List.add(check2);
            CheckOrdiniDaConfermare_DataConsegna a = new CheckOrdiniDaConfermare_DataConsegna(rs.getString("o.dataConsegna"));
        }      
        return checks2List;
    }

    public void mostra_check2() throws ClassNotFoundException, SQLException{
        ArrayList<CheckOrdiniDaConferma_Farmaci> checks2 = check2List();
        DefaultTableModel model = (DefaultTableModel) tabellaFarmaciOrdine.getModel();
        Object[] righe = new Object[5];
        for(int i=0;i<checks2.size(); i++){
            righe[0] = checks2.get(i).getIdFarmaco();
            righe[1] = checks2.get(i).getNome();
            righe[2] = checks2.get(i).getPrincipio();
            righe[3] = checks2.get(i).getDataScadenza();
            righe[4] = checks2.get(i).getQuantita();
            model.addRow(righe);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaFarmaciOrdine = new javax.swing.JTable();
        confermaButton1 = new javax.swing.JButton();
        tornaIndietroButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabellaFarmaciOrdine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Farmaco", "Nome Farmaco", "Principio Attivo", "Data scadenza", "Quantità ordinata", "Quantita ricevuta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabellaFarmaciOrdine);

        confermaButton1.setBackground(new java.awt.Color(7, 139, 163));
        confermaButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confermaButton1.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton1.setText("Conferma");
        confermaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButton1ActionPerformed(evt);
            }
        });

        tornaIndietroButton.setBackground(new java.awt.Color(7, 139, 163));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Annulla");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tornaIndietroButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confermaButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tornaIndietroButton)
                    .addComponent(confermaButton1))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confermaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButton1ActionPerformed
        String quantitaOrdinata = "", quantitaRicevuta = "", nomiSelezionati = "", nomiNonSelezionati = "";
        String noteA = "Questo ordine presenta i seguenti problemi: \n\n";
        boolean flagErrori = true;
        try{
            for(int i=0; i<tabellaFarmaciOrdine.getRowCount(); i++){
                if (!tabellaFarmaciOrdine.isRowSelected(i)){
                    if(tabellaFarmaciOrdine.getModel().getValueAt(i, 5) == null || tabellaFarmaciOrdine.getModel().getValueAt(i, 5) != null){
                        nomiNonSelezionati = tabellaFarmaciOrdine.getModel().getValueAt(i, 1).toString();
                        noteA += "- " + nomiNonSelezionati + ":" + " non ricevuti\n\n";
                        flagErrori = false;
                    }
                }
                if(tabellaFarmaciOrdine.isRowSelected(i)){
                    if (tabellaFarmaciOrdine.getModel().getValueAt(i, 5) != null){
                        quantitaOrdinata = tabellaFarmaciOrdine.getModel().getValueAt(i, 4).toString();
                        quantitaRicevuta = tabellaFarmaciOrdine.getModel().getValueAt(i, 5).toString();
                        nomiSelezionati = tabellaFarmaciOrdine.getModel().getValueAt(i, 1).toString();
                        LocalDateTime dataSistema = LocalDateTime.now();
                        LocalDateTime dataMassima = LocalDate.now().atTime(20, 0);
                        Date dt = new Date();
                        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String data = formato.format(dt);
                        String dataConsegna = CheckOrdiniDaConfermare_DataConsegna.getDataConsegnaCheck();
                        int confrontoDataAttuale_DataMassima = dataSistema.compareTo(dataMassima);
                        int confrontoDataAttuale_DataConsegna = data.compareTo(dataConsegna);
                        if(confrontoDataAttuale_DataConsegna == 0 && confrontoDataAttuale_DataMassima < 0){
                            if(Integer.parseInt(quantitaRicevuta) != Integer.parseInt(quantitaOrdinata)){
                                JOptionPane.showConfirmDialog(null, "La quantità ricevuta è diversa rispetto alla quantità richiesta.\nVerrai contattato il giorno successivo da un operatore per risolvere questo problema.", "Conferma avvenuta con successo",   PLAIN_MESSAGE);
                                noteA += "- " + nomiSelezionati + ":" + " ricevuti " + quantitaRicevuta + " rispetto i "+quantitaOrdinata+" ordinati\n\n";
                                flagErrori = false;
                            }
                        }
                    }
                    else{
                        nomiSelezionati = tabellaFarmaciOrdine.getModel().getValueAt(i, 1).toString();
                        noteA += "- " + nomiSelezionati + ":" + " non ricevuti\n\n";
                        flagErrori = false;
                    }
                }
            }
            if(!flagErrori){
                String note = "";
                String query = "UPDATE ordine SET stato = \"Errore\", note = '"+note+"' WHERE idOrdine = '"+idOrdine+"'";
                PreparedStatement pst;
                pst = connessione.prepareStatement(query);
                pst.executeUpdate();
                System.out.println(noteA);
                String query2 = "UPDATE ordine SET stato = \"Errore\", note = '"+noteA+"' WHERE idOrdine = '"+idOrdine+"'";
                PreparedStatement pst2;
                pst2 = connessione.prepareStatement(query2);
                pst2.executeUpdate();
                this.setVisible(false);
                ConfermaRicezioneOrdini mo = new ConfermaRicezioneOrdini();
                mo.setVisible(true);
                mo.toFront();
                mo.setTitle("Pharmalink - Conferma Ricezione Ordini");  
            }
            else{
                JOptionPane.showConfirmDialog(null, "I farmaci sono stati caricati correttamente nel sistema.", "Conferma avvenuta con successo",   PLAIN_MESSAGE);
                String query = "UPDATE ordine o INNER JOIN farmacoordine fo ON o.idOrdine = fo.idOrdine SET o.ordineCaricato = \"Si\" WHERE o.idOrdine = '"+idOrdine+"'";
                PreparedStatement pst;
                pst = connessione.prepareStatement(query);
                pst.executeUpdate();
                String query2 = "UPDATE ordine SET note = \"Il farmacista ha caricato i farmaci nel suo sistema.\" WHERE idOrdine = '"+idOrdine+"'";
                PreparedStatement pst2;
                pst2 = connessione.prepareStatement(query2);
                pst2.executeUpdate();
                System.out.println(nomiSelezionati);
                this.setVisible(false);
                ConfermaRicezioneOrdini mo = new ConfermaRicezioneOrdini();
                mo.setVisible(true);
                mo.toFront();
                mo.setTitle("Pharmalink - Conferma Ricezione Ordini");  
            }       
        }
        catch(HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex){
            Logger.getLogger(CheckOrdiniDaConfermare_MostraFarmaci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButton1ActionPerformed

    private void tornaIndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornaIndietroButtonActionPerformed
        try{    
            this.setVisible(false);
            ConfermaRicezioneOrdini cro = new ConfermaRicezioneOrdini();
            cro.setVisible(true);
            cro.setResizable(false);
            cro.setTitle("Pharmalink - Conferma Ricezione Ordini");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(CheckOrdiniDaConfermare_MostraFarmaci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabellaFarmaciOrdine;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
