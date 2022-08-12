package Farmacista;

import CredenzialiUtente.CredenzialiUtente;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModificaOrdineSelezionato extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idOrdine;
    public ModificaOrdineSelezionato() throws ClassNotFoundException, SQLException {
        initComponents();
        mostraModifiche();
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
    }

    public ArrayList<Catalogo_ModificaOrdine> modificaList() throws ClassNotFoundException, SQLException{
        ArrayList<Catalogo_ModificaOrdine> modificheList = new ArrayList<>();
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
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
        }
        id = CredenzialiUtente.getId();
        idOrdine = ID_Ordine.getID();
        System.out.println(idOrdine);
        String query = "SELECT o.idOrdine, fo.idFarmaco, f.nome, f.principio, f.scadenza, o.dataConsegna, fo.quantita FROM farmaco f INNER JOIN farmacoordine fo ON f.idFarmaco = fo.idFarmaco INNER JOIN ordine o ON o.idOrdine = fo.idOrdine INNER JOIN utente u ON u.id = o.idUtente WHERE u.id = '"+id+"' AND o.stato = \"In preparazione\" AND o.idOrdine = '"+idOrdine+"'";
        Statement st = connessione.createStatement();
        ResultSet rs = st.executeQuery(query);
        Catalogo_ModificaOrdine check;
        while(rs.next()){
            check = new Catalogo_ModificaOrdine(rs.getString("o.idOrdine"), rs.getString("fo.idFarmaco"), rs.getString("f.nome"), rs.getString("f.principio"), rs.getString("f.scadenza"), rs.getString("o.dataConsegna") , rs.getString("fo.quantita"));
            modificheList.add(check);
        }      
        return modificheList;
    }
    
    public void mostraModifiche() throws ClassNotFoundException, SQLException{
        ArrayList<Catalogo_ModificaOrdine> check = modificaList();
        DefaultTableModel model = (DefaultTableModel) tabellaModifica.getModel();
        Object[] righe = new Object[7];
        for(int i=0;i<check.size(); i++){
            righe[0] = check.get(i).getIdOrdine();
            righe[1] = check.get(i).getIdFarmaco();
            righe[2] = check.get(i).getNomeFarmaco();
            righe[3] = check.get(i).getPrincipioFarmaco();
            righe[4] = check.get(i).getScadenzaFarmaco();
            righe[5] = check.get(i).getDataConsegna();
            righe[6] = check.get(i).getqAttuale();
            model.addRow(righe);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tornaIndietroButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaModifica = new javax.swing.JTable();
        confermaButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tornaIndietroButton.setBackground(new java.awt.Color(7, 139, 163));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Annulla");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        tabellaModifica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ordine", "ID Farmaco", "Nome Farmaco", "Principio Attivo", "Data scadenza", "Data Consegna", "Q.ty Attuale", "Q.ty Nuova"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabellaModifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaModificaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabellaModifica);

        confermaButton1.setBackground(new java.awt.Color(7, 139, 163));
        confermaButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confermaButton1.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton1.setText("Conferma");
        confermaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Nessuna riga selezionata");
        jLabel1.setVisible(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Nessun campo compilato");
        jLabel2.setVisible(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tornaIndietroButton)
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(confermaButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tornaIndietroButton)
                    .addComponent(confermaButton1)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
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
            ModificaOrdine mo = new ModificaOrdine();
            mo.setVisible(true);
            mo.setResizable(false);
            mo.setTitle("Pharmalink - Modifica Ordine");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(ModificaOrdineSelezionato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    private void confermaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButton1ActionPerformed
        PreparedStatement pst1, pst2, pst3;
        Statement st2;
        ResultSet rs2;
        boolean flag=false;
        try{
            String dataScadenzaTabella = "", principio = "", nome = "", idFarmaco = "", idOrdine = "", quantitaNuova = "", quantitaAttuale = "", disponibili = "", dataConsegna = "", diminuisci = "", aumenta = "";
            for(int i=0; i<tabellaModifica.getRowCount();i++){
                if(tabellaModifica.isRowSelected(i) && tabellaModifica.getModel().getValueAt(i, 7) != null){
                    idOrdine = (tabellaModifica.getModel().getValueAt(i, 0).toString());
                    idFarmaco = (tabellaModifica.getModel().getValueAt(i, 1).toString());
                    nome = (tabellaModifica.getModel().getValueAt(i, 2).toString());
                    principio = (tabellaModifica.getModel().getValueAt(i, 3).toString());
                    dataScadenzaTabella = (tabellaModifica.getModel().getValueAt(i, 4).toString());
                    dataConsegna = (tabellaModifica.getModel().getValueAt(i, 5).toString());
                    quantitaAttuale = (tabellaModifica.getModel().getValueAt(i, 6).toString());
                    quantitaNuova = (tabellaModifica.getModel().getValueAt(i, 7).toString());
                    String query = "SELECT quantita FROM farmaco WHERE idFarmaco = '"+idFarmaco+"'";
                    st2 = connessione.createStatement();
                    rs2 = st2.executeQuery(query);
                    while(rs2.next()){
                        disponibili = rs2.getString("quantita");
                    }
                    LocalDate dataScadenza = LocalDate.parse(dataConsegna);
                    LocalDate dataSistema = LocalDate.now();
                    long giorni = ChronoUnit.DAYS.between(dataSistema, dataScadenza);
                    System.out.println(giorni);
                    if(giorni > 2){
                        if(Integer.parseInt(quantitaAttuale) != Integer.parseInt(quantitaNuova) && Integer.parseInt(quantitaNuova) != 0){
                            if(Integer.parseInt(quantitaNuova) < Integer.parseInt(quantitaAttuale)){
                                System.out.println("Quantita nuova: "+quantitaNuova+" \n"+"Quantita attuale: "+quantitaAttuale);
                                String query2 = "UPDATE farmacoordine SET quantita = '"+quantitaNuova+"' WHERE idFarmaco = '"+idFarmaco+"' AND idOrdine = '"+idOrdine+"'";
                                pst1 = connessione.prepareStatement(query2);
                                pst1.executeUpdate();
                                System.out.println("Modifiche effettuate");
                                aumenta = "UPDATE farmaco SET quantita = quantita + '"+(Integer.parseInt(quantitaAttuale) - Integer.parseInt(quantitaNuova))+"' WHERE idFarmaco = '"+idFarmaco+"'";
                                pst3 = connessione.prepareStatement(aumenta);
                                JOptionPane.showMessageDialog(null, "Il farmaco "+nome+" è stato modificato.", "Completamento ordine", JOptionPane.PLAIN_MESSAGE);
                                pst3.executeUpdate();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Non è possibile effettuare la modifica, in quanto hai richiesto una quantità superiore rispetto a quella ordinata.\nProcedere con un nuovo ordine.", "Errore durante la modifica", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else if(Integer.parseInt(quantitaNuova) == Integer.parseInt(quantitaAttuale)){
                            JOptionPane.showMessageDialog(null,"Non è possibile effettuare la modifica, in quanto non è stato riscontrato alcun cambiamento.", "Errore durante la modifica", JOptionPane.WARNING_MESSAGE);
                        }
                        else if(Integer.parseInt(quantitaAttuale) != Integer.parseInt(quantitaNuova) && Integer.parseInt(quantitaNuova) == 0){
                            String query3 = "DELETE FROM farmacoordine WHERE idFarmaco='"+idFarmaco+"' AND idOrdine = '"+idOrdine+"'";
                            JOptionPane.showMessageDialog(null,"Farmaco eliminato con successo.", "Rimozione farmaco", JOptionPane.PLAIN_MESSAGE);
                            pst2 = connessione.prepareStatement(query3);
                            pst2.executeUpdate();
                            aumenta = "UPDATE farmaco SET quantita = quantita + '"+(Integer.parseInt(quantitaAttuale) - Integer.parseInt(quantitaNuova))+"' WHERE idFarmaco = '"+idFarmaco+"'";
                            pst3 = connessione.prepareStatement(aumenta);
                            JOptionPane.showMessageDialog(null, "Il farmaco "+nome+" è stato modificato.", "Completamento ordine", JOptionPane.PLAIN_MESSAGE);
                            pst3.executeUpdate();
                            String controlloOrdine = "SELECT * from ordine WHERE idOrdine = '"+idOrdine+"'";
                            Statement st = connessione.createStatement();
                            ResultSet rs = st.executeQuery(controlloOrdine);
                            while(rs.next()){
                                String cancella = "DELETE FROM ordine WHERE idOrdine = '"+idOrdine+"'";
                                PreparedStatement pst = connessione.prepareStatement(cancella);
                                pst.executeUpdate();
                                flag=true;
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"E' impossibile modificare l'ordine a ridosso della consegna", "Errore", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    jLabel2.setVisible(true);
                }
            }
            if(flag){
                this.setVisible(false);
                ModificaOrdine mo = new ModificaOrdine();
                mo.setVisible(true);
                mo.toFront();
                mo.setTitle("Pharmalink - Modifica Ordine");
            }
            else{
                this.setVisible(false);
                ModificaOrdineSelezionato mo = new ModificaOrdineSelezionato();
                mo.setVisible(true);
                mo.toFront();
                mo.setTitle("Pharmalink - Modifica Ordine");
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ModificaOrdine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButton1ActionPerformed

    private void tabellaModificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaModificaMouseClicked
        for(int i=0; i<tabellaModifica.getRowCount();i++){
            if(tabellaModifica.isRowSelected(i)){
                jLabel1.setVisible(false);
                if(tabellaModifica.getModel().getValueAt(i, 7)==null)
                    jLabel2.setVisible(true);
                else
                    jLabel2.setVisible(false);
            }
        }
    }//GEN-LAST:event_tabellaModificaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabellaModifica;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
