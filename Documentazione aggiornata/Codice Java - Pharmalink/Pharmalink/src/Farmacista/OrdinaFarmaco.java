package Farmacista;

import CredenzialiUtente.CredenzialiUtente;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OrdinaFarmaco extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public OrdinaFarmaco() throws ClassNotFoundException, SQLException {
        initComponents();
        mostra_farmaci();
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
    }
    
    public ArrayList<Catalogo_OrdinaFarmaco> farmacoList() throws ClassNotFoundException, SQLException{
        ArrayList<Catalogo_OrdinaFarmaco> farmaciList = new ArrayList<>();
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
        String query = "SELECT DISTINCT idFarmaco, nome, principio, scadenza, quantita FROM farmaco";
        Statement st = connessione.createStatement();
        ResultSet rs = st.executeQuery(query);
        Catalogo_OrdinaFarmaco catalogo;
        while(rs.next()){
            catalogo = new Catalogo_OrdinaFarmaco(rs.getString("idFarmaco"), rs.getString("nome"), rs.getString("principio"), rs.getString("scadenza"), rs.getString("quantita"));
            farmaciList.add(catalogo);
        }
        return farmaciList;
    }

    public void mostra_farmaci() throws ClassNotFoundException, SQLException{
        ArrayList<Catalogo_OrdinaFarmaco> farmaci = farmacoList();
        DefaultTableModel model = (DefaultTableModel) tabellaFarmaci.getModel();
        Object[] righe = new Object[5];
        for(int i=0;i<farmaci.size(); i++){
            righe[0] = farmaci.get(i).getIdFarmaco();
            righe[1] = farmaci.get(i).getNomeFarmaco();
            righe[2] = farmaci.get(i).getPrincipio();
            righe[3] = farmaci.get(i).getScadenza();
            righe[4] = farmaci.get(i).getQuantita();
            model.addRow(righe);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaFarmaci = new javax.swing.JTable();
        confermaOrdineButton = new javax.swing.JButton();
        esciButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));
        setResizable(false);

        tabellaFarmaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idFarmaco", "Nome", "Principio", "Scadenza", "Disponibili", "Quantita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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

        confermaOrdineButton.setBackground(new java.awt.Color(7, 139, 163));
        confermaOrdineButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confermaOrdineButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaOrdineButton.setText("Conferma");
        confermaOrdineButton.setMinimumSize(new java.awt.Dimension(104, 28));
        confermaOrdineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaOrdineButtonActionPerformed(evt);
            }
        });

        esciButton.setBackground(new java.awt.Color(7, 139, 163));
        esciButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        esciButton.setForeground(new java.awt.Color(255, 255, 255));
        esciButton.setText("Annulla");
        esciButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esciButtonActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(esciButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(confermaOrdineButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(esciButton)
                    .addComponent(confermaOrdineButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void esciButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esciButtonActionPerformed
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
    }//GEN-LAST:event_esciButtonActionPerformed

    private void confermaOrdineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaOrdineButtonActionPerformed
        ResultSet rs, rs2;
        Statement st, st2;
        PreparedStatement pst, pst2, pst3;
        boolean stato = false;
        try{
            int rigaSelezionata = tabellaFarmaci.getSelectedRow();
            String nomeFarmacoSelezionato = (tabellaFarmaci.getModel().getValueAt(rigaSelezionata, 1).toString());
            String idFarmacoSelezionato = (tabellaFarmaci.getModel().getValueAt(rigaSelezionata, 0).toString());
            String queryFarmaco = "SELECT idFarmaco, scadenza, periodoProduzione FROM farmaco WHERE nome = '"+nomeFarmacoSelezionato+"' AND idFarmaco = '"+idFarmacoSelezionato+"'";
            st = connessione.prepareStatement(queryFarmaco);
            rs = st.executeQuery(queryFarmaco);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Errore durante la comunicazione con il DBMS", "Errore", JOptionPane.WARNING_MESSAGE);
                st.close();
                rs.close();
            }
            else{
                String quantita = "";
                String disponibili = "";
                String scadenza = "";
                String nomeFarmaco = "";
                // Data consegna
                Date dt = new Date();
                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data = formato.format(dt);
                Calendar dataConsegna = Calendar.getInstance();
                dataConsegna.setTime(formato.parse(data));
                dataConsegna.add(Calendar.DATE, 7);
                data = formato.format(dataConsegna.getTime());
                for(int i=0; i<tabellaFarmaci.getRowCount(); i++){
                    if(tabellaFarmaci.isRowSelected(i)){
                        disponibili = (tabellaFarmaci.getModel().getValueAt(i, 4).toString());
                        quantita = (tabellaFarmaci.getModel().getValueAt(i,5).toString());
                        scadenza = (tabellaFarmaci.getModel().getValueAt(i, 3).toString());
                        nomeFarmaco = (tabellaFarmaci.getModel().getValueAt(i, 1).toString());
                        System.out.println("Riga "+i+" :"+"\nDisponibili: "+disponibili+"\nQuantita: "+quantita+"\nScadenza: "+scadenza+"\n");
                        // Calcolo i giorni che ci sono tra la data attuale e la data di scadenza del farmaco presente nel DBMS
                        LocalDate dataScadenza = LocalDate.parse(scadenza);
                        LocalDate dataSistema = LocalDate.now();
                        long giorni = ChronoUnit.DAYS.between(dataSistema, dataScadenza);
                        System.out.println("Riga "+i+" :"+"\nFarmaco selezionato: "+nomeFarmaco+"\nData attuale: "+dataSistema+"\nData scadenza: "+dataScadenza+"\nGiorni di differenza: "+giorni);
                        if((giorni<=0) || (Integer.parseInt(disponibili) == 0)){
                            JOptionPane.showMessageDialog(null,"Attenzione!\nIl farmaco " +nomeFarmaco+" è scaduto o terminato.", "Segnalazione farmaci scaduti o esauriti", JOptionPane.WARNING_MESSAGE);
                        }
                        else if(giorni > 0 && (giorni<=60 && Integer.parseInt(quantita)>0)){
                            if (JOptionPane.showConfirmDialog(null, "Il seguente farmaco " +nomeFarmaco+" è in scadenza. Lo vuoi ugualmente?", "Segnalazione farmaci in scadenza", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                                stato = true;
                            }
                        }
                        else if(giorni > 60 && Integer.parseInt(quantita)>0){
                            stato = true;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Errore durante la conferma", "Errore", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
            if(stato){
                    // Data attuale
                    Date date2 = new Date();
                    DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dt2 = dateFormat2.format(date2);
                    // Qui creo l'ordine
                    String query = "INSERT INTO ordine(idUtente, dataConsegna, stato, note, dataOrdine) VALUES ('"+id+"', DATE_ADD(NOW(), INTERVAL 7 DAY), \"In preparazione\", \"Ordine eseguito correttamente\", '"+dt2+"')";
                    pst = connessione.prepareStatement(query);
                    pst.executeUpdate();
                    // Ordine creato
                    String query2 = "SELECT idOrdine from ordine WHERE idUtente = '"+id+"' AND dataOrdine = '"+dt2+"'";
                    st2 = connessione.prepareStatement(query2);
                    rs2 = st2.executeQuery(query2);
                    if(!rs2.next()){
                        JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                        st2.close();
                        rs2.close();
                    }
                    int idOrdine = rs2.getInt("idOrdine");
                    // Recupero idOrdine
                    
                    String quantita = "", idFarmaco = "", scadenza = "", disponibile = "", nomeFarmaco="";
                    String query3 = "INSERT INTO farmacoordine(idOrdine, idFarmaco, quantita) VALUES (?, ?, ?)";
                    pst2 = connessione.prepareStatement(query3);
                    for (int i=0; i<tabellaFarmaci.getRowCount(); i++){
                        if(tabellaFarmaci.isRowSelected(i)){
                            quantita = (tabellaFarmaci.getModel().getValueAt(i, 5).toString());
                            idFarmaco = (tabellaFarmaci.getModel().getValueAt(i, 0).toString());
                            scadenza = (tabellaFarmaci.getModel().getValueAt(i, 3).toString());
                            disponibile = (tabellaFarmaci.getModel().getValueAt(i, 4).toString());
                            nomeFarmaco = (tabellaFarmaci.getModel().getValueAt(i, 1).toString());
                            LocalDate dataScadenza = LocalDate.parse(scadenza);
                            LocalDate dataSistema = LocalDate.now();
                            long giorni = ChronoUnit.DAYS.between(dataSistema, dataScadenza);
                                if(Integer.parseInt(quantita)>0 && giorni > 0){
                                    if(Integer.parseInt(quantita) > Integer.parseInt(disponibile)){
                                        String periodo = rs.getString("periodoProduzione");
                                        Date dt = new Date();
                                        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                        String data = formato.format(dt);
                                        Calendar dataConsegna = Calendar.getInstance();
                                        dataConsegna.setTime(formato.parse(data));
                                        dataConsegna.add(Calendar.DATE, Integer.parseInt(periodo));
                                        data = formato.format(dataConsegna.getTime());
                                        if (JOptionPane.showConfirmDialog(null, "Il seguente farmaco " +nomeFarmaco+" è non è disponibile in quella quantità. Vuoi ugualmente la quantità massima disponibile?\nLa rimanente tornerà disponibile da giorno: '"+data+'"', "Segnalazione quantità insufficiente", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                                            pst2.setInt(1, idOrdine);
                                            pst2.setString(2, idFarmaco);
                                            pst2.setString(3, disponibile);
                                            pst2.executeUpdate();
                                            String completa = "UPDATE farmaco SET quantita = quantita - '"+disponibile+"' WHERE idFarmaco = '"+idFarmaco+"'";
                                            pst3 = connessione.prepareStatement(completa);
                                            pst3.executeUpdate();
                                        }
                                    }else{
                                        pst2.setInt(1, idOrdine);
                                        pst2.setString(2, idFarmaco);
                                        pst2.setString(3, quantita);
                                        pst2.executeUpdate();
                                        String completa = "UPDATE farmaco SET quantita = quantita - '"+quantita+"' WHERE idFarmaco = '"+idFarmaco+"'";
                                        pst3 = connessione.prepareStatement(completa);
                                        pst3.executeUpdate();
                                    }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null,"Farmaci ordinati con successo.", "Completamento ordine", JOptionPane.PLAIN_MESSAGE);
                    this.setVisible(false);
                    OrdinaFarmaco gm = new OrdinaFarmaco();
                    gm.setVisible(true);
                    gm.toFront();
                    gm.setTitle("Pharmalink - Ordina Farmaco");
                    gm.setResizable(false);
                }
            }
        catch (SQLException | ParseException | ClassNotFoundException  ex) {
            Logger.getLogger(OrdinaFarmaco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaOrdineButtonActionPerformed

    private void tabellaFarmaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaFarmaciMouseClicked
        for(int i=0; i<tabellaFarmaci.getRowCount();i++){
            if(tabellaFarmaci.isRowSelected(i)){
                jLabel1.setVisible(false);
                if(tabellaFarmaci.getModel().getValueAt(i, 5)==null)
                    jLabel2.setVisible(true);
                else
                    jLabel2.setVisible(false);
            }
        }
    }//GEN-LAST:event_tabellaFarmaciMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaOrdineButton;
    private javax.swing.JButton esciButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaFarmaci;
    // End of variables declaration//GEN-END:variables
}