package Farmacista;

import IndirizzoIP.IndirizzoIP;
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
    private String id, idContratto;
    public OrdinaFarmaco() throws ClassNotFoundException {
        initComponents();
        mostra_farmaci();
    }
    
    public ArrayList<Catalogo> farmacoList() throws ClassNotFoundException{
        ArrayList<Catalogo> farmaciList = new ArrayList<>();
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
            String query = "SELECT idFarmaco, nome, principio, scadenza, quantita FROM farmaco";
            Statement st = connessione.createStatement();
            ResultSet rs = st.executeQuery(query);
            Catalogo catalogo;
            while(rs.next()){
                catalogo = new Catalogo(rs.getString("idFarmaco"), rs.getString("nome"), rs.getString("principio"), rs.getString("scadenza"), rs.getString("quantita"));
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

        exitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaFarmaci = new javax.swing.JTable();
        confermaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 214, 85));

        exitButton.setBackground(new java.awt.Color(204, 0, 0));
        exitButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
        if (tabellaFarmaci.getColumnModel().getColumnCount() > 0) {
            tabellaFarmaci.getColumnModel().getColumn(0).setHeaderValue("idFarmaco");
            tabellaFarmaci.getColumnModel().getColumn(1).setHeaderValue("Nome");
            tabellaFarmaci.getColumnModel().getColumn(2).setHeaderValue("Principio");
            tabellaFarmaci.getColumnModel().getColumn(3).setHeaderValue("Scadenza");
            tabellaFarmaci.getColumnModel().getColumn(4).setHeaderValue("Disponibili");
            tabellaFarmaci.getColumnModel().getColumn(5).setHeaderValue("Quantita");
        }

        confermaButton.setBackground(new java.awt.Color(0, 204, 0));
        confermaButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Ordina");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                        .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                gcf.setTitle("Pharmalink - Menù Farmacista");
                gcf.setResizable(false);
                gcf.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        ResultSet rs, rs2;
        Statement st, st2;
        PreparedStatement pst, pst2, pst3, pst4;
        boolean stato = false;
        try{
            int rigaSelezionata = tabellaFarmaci.getSelectedRow();
            String nomeFarmacoSelezionato = (tabellaFarmaci.getModel().getValueAt(rigaSelezionata, 1).toString());
            String idFarmacoSelezionato = (tabellaFarmaci.getModel().getValueAt(rigaSelezionata, 0).toString());
            String queryFarmaco = "SELECT idFarmaco, scadenza FROM farmaco WHERE nome = '"+nomeFarmacoSelezionato+"' AND idFarmaco = '"+idFarmacoSelezionato+"'";
            st = connessione.prepareStatement(queryFarmaco);
            rs = st.executeQuery(queryFarmaco);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Errore durante la comunicazione con il DBMS", "Errore", JOptionPane.WARNING_MESSAGE);
                st.close();
                rs.close();
            }
            else{
                String idFarmaco = rs.getString("idFarmaco");
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
                // Data attuale
                Date dt2 = new Date();
                DateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dataAttuale = formato2.format(dt2);
                
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
                    String query = "INSERT INTO ordine(idUtente, dataConsegna, stato, note, dataOrdine) VALUES ('"+id+"', DATE_ADD(NOW(), INTERVAL 7 DAY), \"In preparazione\", \"NULL\", '"+dt2+"')";
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
                    
                    String quantita = "", idFarmaco = "", scadenza = "";
                    String query3 = "INSERT INTO farmacoordine(idOrdine, idFarmaco, quantita) VALUES (?, ?, ?)";
                    pst2 = connessione.prepareStatement(query3);
                    for (int i=0; i<tabellaFarmaci.getRowCount(); i++){
                        if(tabellaFarmaci.isRowSelected(i)){
                            quantita = (tabellaFarmaci.getModel().getValueAt(i, 5).toString());
                            idFarmaco = (tabellaFarmaci.getModel().getValueAt(i, 0).toString());
                            scadenza = (tabellaFarmaci.getModel().getValueAt(i, 3).toString());
                            LocalDate dataScadenza = LocalDate.parse(scadenza);
                            LocalDate dataSistema = LocalDate.now();
                            long giorni = ChronoUnit.DAYS.between(dataSistema, dataScadenza);
                                if(Integer.parseInt(quantita)>0 && giorni > 0){                 
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
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void tabellaFarmaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaFarmaciMouseClicked

    }//GEN-LAST:event_tabellaFarmaciMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaFarmaci;
    // End of variables declaration//GEN-END:variables
}