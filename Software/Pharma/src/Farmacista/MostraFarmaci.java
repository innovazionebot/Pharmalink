package Farmacista;

import IndirizzoIP.IndirizzoIP;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.table.DefaultTableModel;

public class MostraFarmaci extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idOrdine;
    public MostraFarmaci() throws ClassNotFoundException {
        initComponents();
        mostra_check2();
    }
    
    public ArrayList<Check2> check2List() throws ClassNotFoundException{
       ArrayList<Check2> checks2List = new ArrayList<>();
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
           idOrdine = ID_Ordine.getID();
           System.out.println(idOrdine);
           String query = "SELECT f.nome, f.principio, f.scadenza, fo.quantita FROM farmaco f INNER JOIN farmacoordine fo ON f.idFarmaco = fo.idFarmaco INNER JOIN ordine o ON o.idOrdine = fo.idOrdine INNER JOIN utente u ON u.id = o.idUtente WHERE u.id = '"+id+"' AND o.stato = \"Consegnato\" AND o.idOrdine = '"+idOrdine+"' AND fo.ordineCaricato = \"No\"";
           Statement st = connessione.prepareStatement(query);
           ResultSet rs = st.executeQuery(query);
           Check2 check2;
           while(rs.next()){
               check2 = new Check2(rs.getString("f.nome"), rs.getString("f.principio"), rs.getString("f.scadenza"), rs.getString("fo.quantita"));
               checks2List.add(check2);
           }      
       }
       catch (SQLException ex){
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
           JOptionPane.showMessageDialog(null, ex);
       }
       return checks2List;
    }

    public void mostra_check2() throws ClassNotFoundException{
        ArrayList<Check2> checks2 = check2List();
        DefaultTableModel model = (DefaultTableModel) tabellaFarmaciOrdine.getModel();
        Object[] righe = new Object[4];
        for(int i=0;i<checks2.size(); i++){
            righe[0] = checks2.get(i).getNome();
            righe[1] = checks2.get(i).getPrincipio();
            righe[2] = checks2.get(i).getDataScadenza();
            righe[3] = checks2.get(i).getQuantita();
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
                "Nome Farmaco", "Principio Attivo", "Data scadenza", "Quantità ordinata", "Quantita ricevuta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabellaFarmaciOrdine);

        confermaButton1.setBackground(new java.awt.Color(0, 204, 51));
        confermaButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        confermaButton1.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton1.setText("Conferma");
        confermaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButton1ActionPerformed(evt);
            }
        });

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Torna indietro");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confermaButton1)
                    .addComponent(tornaIndietroButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confermaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButton1ActionPerformed
        String quantitaOrdinata = "", quantitaRicevuta = "", nome = "";
        try{
            for(int i=0; i<tabellaFarmaciOrdine.getRowCount(); i++){
                if(tabellaFarmaciOrdine.isRowSelected(i)){
                    quantitaOrdinata = tabellaFarmaciOrdine.getModel().getValueAt(i, 3).toString();
                    quantitaRicevuta = tabellaFarmaciOrdine.getModel().getValueAt(i, 4).toString();
                    nome = tabellaFarmaciOrdine.getModel().getValueAt(i, 0).toString();
                    if(Integer.parseInt(quantitaRicevuta) == Integer.parseInt(quantitaOrdinata)){
                        JOptionPane.showConfirmDialog(null, "I farmaci sono stati caricati correttamente nel sistema.", "Conferma avvenuta con successo",   PLAIN_MESSAGE);
                        String query = "UPDATE farmacoordine SET ordineCaricato = \"Si\" WHERE idOrdine = '"+idOrdine+"'";
                        PreparedStatement pst;
                        pst = connessione.prepareStatement(query);
                        pst.executeUpdate();
                    }
                    else if(Integer.parseInt(quantitaRicevuta) != Integer.parseInt(quantitaOrdinata)){
                        JOptionPane.showConfirmDialog(null, "La quantità ricevuta è diversa rispetto alla quantità richiesta.\nVerrai contattato il giorno successivo da un operatore per risolvere questo problema.", "Conferma avvenuta con successo",   PLAIN_MESSAGE);
                        String query = "UPDATE ordine SET stato = \"Errore\" WHERE idOrdine = '"+idOrdine+"'";
                        PreparedStatement pst;
                        pst = connessione.prepareStatement(query);
                        pst.executeUpdate();
                    }
                    else{
                        JOptionPane.showConfirmDialog(null, "Nessuna quantità inserita.", "Errore durante la compilazione",   WARNING_MESSAGE);
                    }
                }
            }
            this.setVisible(false);
            CheckOrdine co = new CheckOrdine();
            co.setVisible(true);
            co.toFront();
            co.setTitle("Pharmalink - Check Ordine");
            co.setResizable(false);
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(MostraFarmaci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confermaButton1ActionPerformed

    private void tornaIndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornaIndietroButtonActionPerformed
        JFrame frame;
        frame = new JFrame("Uscita");
        frame.setResizable(false);
        if (JOptionPane.showConfirmDialog(frame, "Sei sicuro di voler abbandonare la pagina?", "Avviso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION){
            try {
                this.toBack();
                this.setVisible(false);
                CheckOrdine f = new CheckOrdine();
                f.toFront();
                f.setVisible(true);
                f.setTitle("Pharmalink - Check Ordine");
                f.setResizable(false);
                f.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CheckOrdine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabellaFarmaciOrdine;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
