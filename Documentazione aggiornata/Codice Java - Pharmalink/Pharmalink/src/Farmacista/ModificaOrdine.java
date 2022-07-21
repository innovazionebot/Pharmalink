package Farmacista;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import CredenzialiUtente.CredenzialiUtente;

public class ModificaOrdine extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public ModificaOrdine() throws ClassNotFoundException, SQLException {
        initComponents();
        mostra_farmaci();
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
            System.out.println("Connessione non avvenuta, errore");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
        }
            id = CredenzialiUtente.getId();
            String query = "SELECT fo.idOrdine, f.idFarmaco, f.nome, f.principio, f.scadenza, f.quantita, fo.quantita, o.dataConsegna FROM farmaco f INNER JOIN farmacoordine fo ON f.idFarmaco = fo.idFarmaco INNER JOIN ordine o ON fo.idOrdine = o.idOrdine AND o.stato = \"In preparazione\" AND o.idUtente = '"+id+"'";
            Statement st = connessione.createStatement();
            ResultSet rs = st.executeQuery(query);
            Catalogo_ModificaOrdine catalogoModifica;
            while(rs.next()){
                catalogoModifica = new Catalogo_ModificaOrdine(rs.getString("fo.idOrdine"), rs.getString("f.idFarmaco"), rs.getString("f.nome"), rs.getString("f.principio"), rs.getString("f.scadenza"), rs.getString("o.dataConsegna"), rs.getString("f.quantita"), rs.getString("fo.quantita"));
                modificheList.add(catalogoModifica);
            }      
        return modificheList;
    }

    public void mostra_farmaci() throws ClassNotFoundException, SQLException{
        ArrayList<Catalogo_ModificaOrdine> modifiche = modificaList();
        DefaultTableModel model = (DefaultTableModel) tabellaModifica.getModel();
        Object[] righe = new Object[8];
        for(int i=0;i<modifiche.size(); i++){
            righe[0] = modifiche.get(i).getIDOrdine();
            righe[1] = modifiche.get(i).getIdFarmaco();
            righe[2] = modifiche.get(i).getNome();
            righe[3] = modifiche.get(i).getPrincipio();
            righe[4] = modifiche.get(i).getScadenza();
            righe[5] = modifiche.get(i).getDataConsegna();
            righe[6] = modifiche.get(i).getDisponibili();
            righe[7] = modifiche.get(i).getQuantitaAttuale();
            model.addRow(righe);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        confermaButton = new javax.swing.JButton();
        annullaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaModifica = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        confermaButton.setBackground(new java.awt.Color(7, 139, 163));
        confermaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Conferma modifiche");
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

        tabellaModifica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ordine", "ID Farmaco", "Nome", "Principio", "Scadenza", "Disponibili", "Data Consegna", "Qty. attuale", "Qty nuova"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabellaModifica.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabellaModifica);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(annullaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annullaButton))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annullaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaButtonActionPerformed
        try {
            this.setVisible(false);
            GestioneOrdini go = new GestioneOrdini();
            go.setVisible(true);
            go.setResizable(false);
            go.setTitle("Pharmalink - Menù Farmacista");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(ModificaOrdine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_annullaButtonActionPerformed

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        PreparedStatement pst1, pst2, pst3;
        try{
            String nome = "", idFarmaco = "", idOrdine = "", quantitaNuova = "", quantitaAttuale = "", disponibili = "", dataConsegna = "", diminuisci = "", aumenta = "";
            for(int i=0; i<tabellaModifica.getRowCount();i++){
                if(tabellaModifica.isRowSelected(i)){
                    quantitaAttuale = (tabellaModifica.getModel().getValueAt(i, 7).toString());
                    disponibili = (tabellaModifica.getModel().getValueAt(i, 5).toString());
                    quantitaNuova = (tabellaModifica.getModel().getValueAt(i, 8).toString());
                    idFarmaco = (tabellaModifica.getModel().getValueAt(i, 1).toString());
                    idOrdine = (tabellaModifica.getModel().getValueAt(i, 0).toString());
                    dataConsegna = (tabellaModifica.getModel().getValueAt(i, 6).toString());
                    nome = (tabellaModifica.getModel().getValueAt(i, 2).toString());
                    LocalDate dataScadenza = LocalDate.parse(dataConsegna);
                    LocalDate dataSistema = LocalDate.now();
                    long giorni = ChronoUnit.DAYS.between(dataSistema, dataScadenza);
                    System.out.println(giorni);
                    if(giorni > 2){
                        if(Integer.parseInt(quantitaAttuale) != Integer.parseInt(quantitaNuova) && Integer.parseInt(quantitaNuova) != 0){
                            if(Integer.parseInt(quantitaNuova) > Integer.parseInt(quantitaAttuale)){
                                System.out.println("Quantita nuova: "+quantitaNuova+" \n"+"Quantita attuale: "+quantitaAttuale);
                                String query2 = "UPDATE farmacoordine SET quantita = '"+quantitaNuova+"' WHERE idFarmaco = '"+idFarmaco+"' AND idOrdine = '"+idOrdine+"'";
                                diminuisci = "UPDATE farmaco SET quantita = quantita - '"+(Integer.parseInt(quantitaNuova) - Integer.parseInt(quantitaAttuale))+"'";
                                System.out.println(diminuisci);
                                pst1 = connessione.prepareStatement(query2);
                                pst3 = connessione.prepareStatement(diminuisci);
                                JOptionPane.showMessageDialog(null, "Il farmaco "+nome+" è stato modificato.", "Completamento ordine", JOptionPane.PLAIN_MESSAGE);
                                pst3.executeUpdate();
                                pst1.executeUpdate();
                            }
                            else{
                                System.out.println("Quantita nuova: "+quantitaNuova+" \n"+"Quantita attuale: "+quantitaAttuale);
                                String query2 = "UPDATE farmacoordine SET quantita = '"+quantitaNuova+"' WHERE idFarmaco = '"+idFarmaco+"' AND idOrdine = '"+idOrdine+"'";
                                aumenta = "UPDATE farmaco SET quantita = quantita + '"+(Integer.parseInt(quantitaAttuale) - Integer.parseInt(quantitaNuova))+"'";
                                System.out.println(aumenta);
                                pst1 = connessione.prepareStatement(query2);
                                pst3 = connessione.prepareStatement(aumenta);
                                JOptionPane.showMessageDialog(null, "Il farmaco "+nome+" è stato modificato.", "Completamento ordine", JOptionPane.PLAIN_MESSAGE);
                                pst3.executeUpdate();
                                pst1.executeUpdate();
                            }
                        }
                        else if(Integer.parseInt(quantitaNuova) == Integer.parseInt(quantitaAttuale)){
                            JOptionPane.showMessageDialog(null,"Nessuna modifica effettuata.", "Errore durante la modifica", JOptionPane.WARNING_MESSAGE);
                        }
                        else if(Integer.parseInt(quantitaAttuale) != Integer.parseInt(quantitaNuova) && Integer.parseInt(quantitaNuova) == 0){
                            String query3 = "DELETE FROM farmacoordine WHERE idFarmaco='"+idFarmaco+"' AND idOrdine = '"+idOrdine+"'";
                            JOptionPane.showMessageDialog(null,"Farmaco eliminato con successo.", "Rimozione farmaco", JOptionPane.PLAIN_MESSAGE);
                            pst2 = connessione.prepareStatement(query3);
                            pst2.executeUpdate();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"E' impossibile modificare l'ordine a ridosso della consegna", "Errore", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            this.setVisible(false);
            ModificaOrdine mo = new ModificaOrdine();
            mo.setVisible(true);
            mo.toFront();
            mo.setTitle("Pharmalink - Modifica Ordine");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ModificaOrdine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullaButton;
    private javax.swing.JButton confermaButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaModifica;
    // End of variables declaration//GEN-END:variables
}
