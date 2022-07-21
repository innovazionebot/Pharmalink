package Fattorino;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import IndirizzoIP.IndirizzoIP;

public class PresaInCarico extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public PresaInCarico() throws ClassNotFoundException {
        IndirizzoIP address = new IndirizzoIP();
        String url = "jdbc:mysql://" + address.ip + "/";
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
        }
        initComponents();
        mostra_carico();
    }
    
    public ArrayList<Ordini> caricoList() throws ClassNotFoundException{
        id = CheckIDFattorino.getID();
        ArrayList<Ordini> carichiList = new ArrayList<>();
        try{
            //Ordine con id più piccolo da assegnare al fattorino
            String query = "SELECT MIN(o.idOrdine), u.nome, u.cognome, u.indirizzo FROM ordine o INNER JOIN utente u ON o.idUtente = u.id WHERE u.lavoro = 'farmacista' AND o.stato='In preparazione'";
            // Prendo il flag di utente
            String query2 = "SELECT flag FROM utente WHERE id = '"+id+"'";
            Statement st = connessione.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            Statement st2 = connessione.prepareStatement(query2);
            ResultSet rs2 = st2.executeQuery(query2);
            System.out.println("ID Fattorino: "+id);
            Ordini ordini;
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Errore durante la comunicazione con il DBMS.", "Errore", JOptionPane.WARNING_MESSAGE);
                st.close();
                rs.close();
            }
            else if(!rs2.next()){
                    JOptionPane.showMessageDialog(null,"Errore durante la comunicazione con il DBMS.", "Errore", JOptionPane.WARNING_MESSAGE);
                    st2.close();
                    rs2.close();
            }
            else{
                String flag = rs2.getString("flag");
                System.out.println("Flag attuale: "+flag);
                if(Integer.parseInt(flag)==0){
                    ordini = new Ordini (rs.getString("MIN(o.idOrdine)"), rs.getString("u.nome"), rs.getString("u.cognome"), rs.getString("u.indirizzo"));
                    carichiList.add(ordini);
                    String idOrdine = rs.getString("MIN(o.idOrdine)");
                    String aggiorna = "UPDATE ordine SET stato = \"In consegna\", fattorino = '"+id+"' WHERE idOrdine = '"+idOrdine+"'";
                    String setFlag = "UPDATE utente SET flag = 1 WHERE id = '"+id+"'";
                    PreparedStatement pst, pst2;
                    pst = connessione.prepareStatement(aggiorna);
                    pst2 = connessione.prepareStatement(setFlag);
                    pst2.executeUpdate();
                    pst.executeUpdate();
                    IDOrdine_PC controlloIdOrdine = new IDOrdine_PC(idOrdine);
                }
                else{
                    String query3 = "SELECT idOrdine FROM ordine WHERE fattorino = '"+id+"' AND stato = \"In consegna\"";
                    Statement st3 = connessione.prepareStatement(query3);
                    ResultSet rs3 = st.executeQuery(query3);
                    if(!rs3.next()){
                        JOptionPane.showMessageDialog(null,"Nessun ordine da prendere in consegna.", "Errore", JOptionPane.WARNING_MESSAGE);
                        st3.close();
                        rs3.close();
                    }
                    else{
                        String idOrdine = rs3.getString("idOrdine");
                        IDOrdine_PC controlloIdOrdine = new IDOrdine_PC(idOrdine);
                        String query4 = "SELECT o.idOrdine, u.nome, u.cognome, u.indirizzo FROM ordine o INNER JOIN utente u ON o.idUtente = u.id AND u.lavoro= \"farmacista\" AND o.stato = \"In consegna\" AND o.idOrdine = '"+idOrdine+"'";
                        Statement st4 = connessione.prepareStatement(query4);
                        ResultSet rs4 = st4.executeQuery(query4);
                        if(!rs4.next()){
                            JOptionPane.showMessageDialog(null,"Nessun ordine da prendere in consegna.", "Errore", JOptionPane.WARNING_MESSAGE);
                            st4.close();
                            rs4.close();
                            this.setVisible(false);
                            PresaInCarico to = new PresaInCarico();
                            to.setVisible(true);
                            to.toFront();
                            to.setTitle("Pharmalink - Menù Fattorino");
                            to.setResizable(false);
                            to.getContentPane().setBackground(new java.awt.Color(198,231,201));
                            CheckIDFattorino controlloIdFattorino = new CheckIDFattorino(id);
                        }
                        ordini = new Ordini(rs4.getString("o.idOrdine"), rs4.getString("u.nome"), rs4.getString("u.cognome"), rs4.getString("u.indirizzo"));
                        carichiList.add(ordini); 
                    }
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(PresaInCarico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carichiList;
       
    }

    public void mostra_carico() throws ClassNotFoundException{
        ArrayList<Ordini> carichi = caricoList();
        DefaultTableModel model = (DefaultTableModel) tabellaCarico.getModel();
        Object[] righe = new Object[4];
        for(int i=0;i<carichi.size(); i++){
            righe[0] = carichi.get(i).getIdOrdine();
            righe[1] = carichi.get(i).getNome();
            righe[2] = carichi.get(i).getCognome();
            righe[3] = carichi.get(i).getIndirizzo();
            model.addRow(righe);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tornaIndietroButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaCarico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tornaIndietroButton.setBackground(new java.awt.Color(204, 0, 0));
        tornaIndietroButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tornaIndietroButton.setForeground(new java.awt.Color(255, 255, 255));
        tornaIndietroButton.setText("Torna al menù principale");
        tornaIndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaIndietroButtonActionPerformed(evt);
            }
        });

        tabellaCarico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ordine", "Nome", "Cognome", "Indirizzo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabellaCarico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(tornaIndietroButton)
                        .addGap(0, 114, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(tornaIndietroButton)
                .addContainerGap(14, Short.MAX_VALUE))
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
                Fattorino f = new Fattorino();
                f.toFront();
                f.setVisible(true);
                f.setTitle("Pharmalink - Fattorino Menù");
                f.setResizable(false);
                f.getContentPane().setBackground(new java.awt.Color(198,231,201));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PresaInCarico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tornaIndietroButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaCarico;
    private javax.swing.JButton tornaIndietroButton;
    // End of variables declaration//GEN-END:variables
}
