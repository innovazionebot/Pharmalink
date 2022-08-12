/*
Questa classe permette di controllare lo stato dell'ordine, cambiandolo da "In preparazione" a "Pronto per la spedizione"
*/
package Farmacista;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ControlloStato {
    private Connection connessione;
    public ControlloStato() throws ClassNotFoundException{
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
        stato();
    }

    private void stato() {
       Statement st;
       ResultSet rs;
       try{
           String query = "SELECT idOrdine, dataConsegna, stato FROM ordine";
           st = connessione.createStatement();
           rs = st.executeQuery(query);
           while(rs.next()){
               String idOrdine = rs.getString("idOrdine");
               String dataConsegna = rs.getString("dataConsegna");
               String stato = rs.getString("stato");
               LocalDate dataSistema = LocalDate.now();
               LocalDate data = LocalDate.parse(dataConsegna);
               long giorni = ChronoUnit.DAYS.between(dataSistema, data);
               System.out.println("Giorni distanza: "+giorni);
               if(giorni==3){
                   String aggiorna = "UPDATE ordine SET stato = \"Pronto per la consegna\" WHERE idOrdine = '"+idOrdine+"'";
                   PreparedStatement pst = connessione.prepareStatement(aggiorna);
                   pst.executeUpdate();
               }
           }
           rs.close();
           st.close();
       }
       catch(SQLException ex){
            Logger.getLogger(ControlloScorte.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
       }
    }
}
