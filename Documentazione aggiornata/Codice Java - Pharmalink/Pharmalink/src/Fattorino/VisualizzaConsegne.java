package Fattorino;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import CredenzialiUtente.CredenzialiUtente;

public class VisualizzaConsegne extends javax.swing.JFrame {
    private Connection connessione;
    private String id;
    public VisualizzaConsegne() throws ClassNotFoundException {
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
        initComponents();
        mostra_carico();
    }
    
    public ArrayList<Ordini> caricoList() throws ClassNotFoundException{
        id = CredenzialiUtente.getId();
        ArrayList<Ordini> carichiList = new ArrayList<>();
        try{
            //Ordine con id più piccolo da assegnare al fattorino
            String query = "SELECT MIN(o.idOrdine), u.nome, u.cognome, u.indirizzo FROM ordine o INNER JOIN utente u ON o.idUtente = u.id WHERE u.lavoro = 'farmacista' AND o.stato='Pronto per la consegna'";
            // Prendo il flag di utente
            String query2 = "SELECT flag FROM utente WHERE id = '"+id+"'";
            Statement st = connessione.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            Statement st2 = connessione.prepareStatement(query2);
            ResultSet rs2 = st2.executeQuery(query2);
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
                String ordine = rs.getString("MIN(o.idOrdine)");
                if(Integer.parseInt(flag)==0 && ordine == null){
                    IDOrdine_PC controlloIdOrdine = new IDOrdine_PC("");
                }
                else if(Integer.parseInt(flag)==0 && ordine != null){
                    ordini = new Ordini (rs.getString("MIN(o.idOrdine)"), rs.getString("u.nome"), rs.getString("u.cognome"), rs.getString("u.indirizzo"));
                    carichiList.add(ordini);
                    String idOrdine = rs.getString("MIN(o.idOrdine)");
                    System.out.println("Id Ordine: " + idOrdine);
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
                        System.out.println("ID ORDINE: " + controlloIdOrdine.toString());
                        String query4 = "SELECT o.idOrdine, u.nome, u.cognome, u.indirizzo FROM ordine o INNER JOIN utente u ON o.idUtente = u.id AND u.lavoro= \"farmacista\" AND o.stato = \"In consegna\" AND o.idOrdine = '"+idOrdine+"'";
                        Statement st4 = connessione.prepareStatement(query4);
                        ResultSet rs4 = st4.executeQuery(query4);
                        if(!rs4.next()){
                            JOptionPane.showMessageDialog(null,"Nessun ordine da prendere in consegna.", "Errore", JOptionPane.WARNING_MESSAGE);
                            st4.close();
                            rs4.close();
                            this.setVisible(false);
                            VisualizzaConsegne to = new VisualizzaConsegne();
                            to.setVisible(true);
                            to.toFront();
                            to.setTitle("Pharmalink - Menù Fattorino");
                            to.setResizable(false);
                            String nome = rs.getString("u.nome");
                            String cognome = rs.getString("u.cognome");
                            String idContratto = "";
                            CredenzialiUtente controlloIdFattorino = new CredenzialiUtente(id, nome, cognome, idContratto);
                        }
                        ordini = new Ordini(rs4.getString("o.idOrdine"), rs4.getString("u.nome"), rs4.getString("u.cognome"), rs4.getString("u.indirizzo"));
                        carichiList.add(ordini); 
                    }
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(VisualizzaConsegne.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaCarico = new javax.swing.JTable();
        annullaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(221, 221, 221));

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

        annullaButton.setBackground(new java.awt.Color(7, 139, 163));
        annullaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        annullaButton.setForeground(new java.awt.Color(255, 255, 255));
        annullaButton.setText("Annulla");
        annullaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(annullaButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(annullaButton)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            Fattorino fattorino = new Fattorino();
            fattorino.setVisible(true);
            fattorino.setResizable(false);
            fattorino.setTitle("Pharmalink - Menù Fattorino");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(VisualizzaConsegne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_annullaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullaButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaCarico;
    // End of variables declaration//GEN-END:variables
}
