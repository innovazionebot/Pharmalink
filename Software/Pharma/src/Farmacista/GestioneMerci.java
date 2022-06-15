package Farmacista;

import Login.Login;
import java.awt.HeadlessException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GestioneMerci extends javax.swing.JFrame {
    private Connection connessione;
    private String id, idContratto;
    public GestioneMerci() throws ClassNotFoundException {
        initComponents();
        mostra_farmaci();
        /*
        quantitaField.setEditable(true);
        scadenzaField.setEditable(false);
        nomeFarmacoField.setEditable(false);
        principioField.setEditable(false);
        */
    }
    
    public ArrayList<Catalogo> farmacoList() throws ClassNotFoundException{
        ArrayList<Catalogo> farmaciList = new ArrayList<>();
        try{
            String url = "jdbc:mysql://localhost:3306/";
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

        exitButton.setBackground(new java.awt.Color(204, 0, 0));
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

        confermaButton.setBackground(new java.awt.Color(0, 204, 0));
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Conferma");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(confermaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Farmacista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        ResultSet rs, rs2;
        Statement st, st2;
        try{
            int rigaSelezionata = tabellaFarmaci.getSelectedRow();
            String nomeFarmaco = (tabellaFarmaci.getModel().getValueAt(rigaSelezionata, 1).toString());
            String q = "SELECT idFarmaco from farmaco WHERE nome = '"+nomeFarmaco+"'";
            st = connessione.prepareStatement(q);
            rs = st.executeQuery(q);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                st.close();
                rs.close();
            }
            else{
                String idFarmaco = rs.getString("idFarmaco");
                String quantita = "";
                String statoConsegna = "In preparazione";
                String noteConsegna = "NULL";
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dt = dateFormat.format(date);
                Calendar c = Calendar.getInstance();
                c.setTime(dateFormat.parse(dt));
                c.add(Calendar.DATE, 7);
                dt = dateFormat.format(c.getTime());     
                
                Date date2 = new Date();
                DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dt2 = dateFormat2.format(date2);
                
                PreparedStatement pst, pst2, pst3;
                String query = "INSERT INTO ordine(idUtente, dataConsegna, stato, note, dataOrdine) VALUES ('"+id+"', DATE_ADD(NOW(), INTERVAL 7 DAY), \"In preparazione\", \"NULL\", '"+dt2+"')";
                pst = connessione.prepareStatement(query);
                pst.executeUpdate();
                // Ordine creato
                
                String query2 = "SELECT idOrdine from ordine WHERE idUtente = '"+id+"' AND dataOrdine = '"+dt2+"'";
                System.out.println("prova");
                st2 = connessione.prepareStatement(query2);
                rs2 = st2.executeQuery(query2);
                if(!rs2.next()){
                    JOptionPane.showMessageDialog(null,"Errore nel sistema.", "Errore", JOptionPane.WARNING_MESSAGE);
                    st2.close();
                    rs2.close();
                }
                int idOrdine = rs2.getInt("idOrdine");
                // idOrdine return
                String query3 = "INSERT INTO farmacoordine(idOrdine, idFarmaco, quantita) VALUES (?, ?, ?)";
                pst2 = connessione.prepareStatement(query3);
                for (int i=0; i<tabellaFarmaci.getSelectedRowCount(); i++){
                    quantita = (tabellaFarmaci.getValueAt(i, 5).toString());
                    idFarmaco = (tabellaFarmaci.getValueAt(i, 0).toString());
                    if(Integer.parseInt(quantita)>0){
                        pst2.setInt(1, idOrdine);
                        pst2.setString(2, idFarmaco);
                        pst2.setString(3, quantita);
                        pst2.executeUpdate();
                        String completa = "UPDATE farmaco SET quantita = quantita - '"+quantita+"' WHERE idFarmaco = '"+idFarmaco+"'";
                        pst3 = connessione.prepareStatement(completa);
                        pst3.executeUpdate();
                    }
                }
                this.setVisible(false);
                GestioneMerci gm = new GestioneMerci();
                gm.setVisible(true);
                gm.toFront();
                gm.setTitle("Pharmalink - Gestione Merci");
                gm.setResizable(false);
            }
        } catch (SQLException | ParseException | ClassNotFoundException ex) {
            Logger.getLogger(GestioneMerci.class.getName()).log(Level.SEVERE, null, ex);
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
