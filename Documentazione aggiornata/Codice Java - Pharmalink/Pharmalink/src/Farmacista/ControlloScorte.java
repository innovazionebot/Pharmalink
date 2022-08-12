package Farmacista;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.logging.*;

public class ControlloScorte {
    private Connection connessione;
    public ControlloScorte() throws ClassNotFoundException, IOException, InterruptedException, ParseException{
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
        gestione();
    }

    private void gestione() throws ParseException {
        //Gestione azzeramento farmaci
        Statement st;
        ResultSet rs;
        LocalDate data = LocalDate.now();
        try{
            String query = "SELECT idFarmaco, scadenza FROM farmaco";
            st = connessione.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String scadenza = rs.getString("scadenza");
                LocalDate dataScadenza = LocalDate.parse(scadenza);
                long giorni = ChronoUnit.DAYS.between(data, dataScadenza);
                if(giorni<60){
                    String idFarmaco = rs.getString("idFarmaco");
                    String elimina = "UPDATE farmaco SET quantita = 0 WHERE idFarmaco = '"+idFarmaco+"'";
                    PreparedStatement pst = connessione.prepareStatement(elimina);
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
        //Gestione ricarica
        Statement st2;
        ResultSet rs2;
        try{
            String query = "SELECT * FROM farmaco";
            st2 = connessione.createStatement();
            rs2 = st2.executeQuery(query);
            while(rs2.next()){
                String periodoProduzione = rs2.getString("periodoProduzione");
                String ricaricato = rs2.getString("ricaricato");
                int giorni = data.getDayOfMonth();
                if((giorni % Integer.parseInt(periodoProduzione) == 0) && (Integer.parseInt(ricaricato) == 0)){
                    String nome = rs2.getString("nome");
                    String dataScadenza = rs2.getString("scadenza");
                    String principio = rs2.getString("principio");
                    String daBanco = rs2.getString("da_banco");
                    String idFarmaco = rs2.getString("idFarmaco");
                    Date dt = new Date();
                    DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    String dataScadenzaNuova = formato.format(dt);
                    Calendar dataFarmaco = Calendar.getInstance();
                    dataFarmaco.setTime(formato.parse(dataScadenza));
                    dataFarmaco.add(Calendar.DATE, 450);
                    dataScadenzaNuova = formato.format(dataFarmaco.getTime());
                    String query2 = "INSERT INTO farmaco (nome, principio, scadenza, quantita, periodoProduzione, da_banco, ricaricato) VALUES ('"+nome+"', '"+principio+"', '"+dataScadenzaNuova+"', 1000, '"+periodoProduzione+"', '"+daBanco+"', 1)";
                    PreparedStatement pst = connessione.prepareStatement(query2);
                    pst.executeUpdate();
                    System.out.println("Aggiunti i seguenti farmaci\n");
                    System.out.println("Nome Farmaco: "+nome+"\n"+"Principio: "+principio+"\n");
                    String query3 = "UPDATE farmaco SET ricaricato = 1 WHERE idFarmaco = '"+idFarmaco+"'";
                    PreparedStatement pst3 = connessione.prepareStatement(query3);
                    pst3.executeUpdate();
                }
                else if((giorni % Integer.parseInt(periodoProduzione) != 0) && (Integer.parseInt(ricaricato) == 1)){
                    String idFarmaco = rs2.getString("idFarmaco");
                    String query3 = "UPDATE farmaco SET ricaricato = 0 WHERE idFarmaco = '"+idFarmaco+"'";
                    PreparedStatement pst2 = connessione.prepareStatement(query3);
                    pst2.executeUpdate();
                    System.out.println("Modificati i seguenti farmaci\n");
                    System.out.println("ID Farmaco: "+idFarmaco+"\n");
                }
            }
            st2.close();
            rs2.close();
        }
        catch(SQLException ex){
            Logger.getLogger(ControlloScorte.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Il software non è riuscito a connettersi al database", "Errore durante la comunicazione con il DBMS", JOptionPane.WARNING_MESSAGE);
        }
    }
}
