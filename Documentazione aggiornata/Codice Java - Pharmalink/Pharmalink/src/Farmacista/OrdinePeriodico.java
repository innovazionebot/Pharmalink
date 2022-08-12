package Farmacista;

import java.io.IOException;
import java.net.InetAddress;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class OrdinePeriodico {
    private Connection connessione;
    private String id;
    public OrdinePeriodico() throws ClassNotFoundException, IOException{
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
        a();
    }

    private void a() throws IOException {
        
        String TIME_SERVER = "time-a.nist.gov";   
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
        TimeInfo timeInfo = timeClient.getTime(inetAddress);
        long returnTime = timeInfo.getReturnTime();
        Date time = new Date(returnTime);
        String tempo = time.toString();
        String[] array = tempo.split(" ");
        Statement st;
        ResultSet rs;
        try{
            String query = "SELECT f.idContratto, f.idFarmaco, f.periodo, f.quantita, f.spedito, c.idUtente FROM farmacocontratto f INNER JOIN contratto c ON f.idContratto = c.idContratto";
            st = connessione.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String periodo = rs.getString("f.periodo");
                String idUtente = rs.getString("c.idUtente");
                String statoSpedizione = rs.getString("f.spedito");
                if(((int)Integer.parseInt(array[2]) % Integer.parseInt(periodo) == 0) && (Integer.parseInt(statoSpedizione) == 0)){
                    String idContratto = rs.getString("f.idContratto");
                    String idFarmaco = rs.getString("f.idFarmaco");
                    String quantita = rs.getString("f.quantita");
                    System.out.println(idContratto + " " + idFarmaco);
                    // Serve per creare la data di consegna
                    Date dt = new Date();
                    DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String data = formato.format(dt);
                    Calendar dataConsegna = Calendar.getInstance();
                    dataConsegna.setTime(formato.parse(data));
                    dataConsegna.add(Calendar.DATE, 7);
                    data = formato.format(dataConsegna.getTime());
                    // Serve per creare la data dell'ordine
                    Date date2 = new Date();
                    DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dt2 = dateFormat2.format(date2);
                    String eseguiOrdine = "INSERT INTO ordine (idUtente, dataConsegna, stato, note, dataOrdine) VALUES ('"+idUtente+"', '"+data+"', \"In preparazione\", \"Ordine periodico\", '"+dt2+"')";
                    PreparedStatement pst = connessione.prepareStatement(eseguiOrdine);
                    pst.executeUpdate();
                    String queryID = "SELECT idOrdine FROM ordine WHERE idUtente = '"+idUtente+"' AND dataOrdine = '"+dt2+"'";
                    Statement st3 = connessione.createStatement();
                    ResultSet rs3 = st3.executeQuery(queryID);
                    while(rs3.next()){
                        String idOrdine = rs3.getString("idOrdine");
                        String farmacoOrdine = "INSERT INTO farmacoordine(idOrdine, idFarmaco, quantita) VALUES ('"+idOrdine+"', '"+idFarmaco+"', '"+quantita+"')";
                        PreparedStatement pst3 = connessione.prepareStatement(farmacoOrdine);
                        pst3.executeUpdate();
                    }
                    rs3.close();
                    st3.close();
                    String cambiaStato = "UPDATE farmacocontratto SET spedito = 1 WHERE idContratto = '"+idContratto+"' AND idFarmaco = '"+idFarmaco+"'";
                    PreparedStatement pst2 = connessione.prepareStatement(cambiaStato);
                    pst2.executeUpdate();
                    String riduciQuantita = "UPDATE farmaco SET quantita = quantita - '"+quantita+"' WHERE idContratto = '"+idContratto+"' AND idFarmaco = '"+idFarmaco+"'";
                    PreparedStatement pst3 = connessione.prepareStatement(riduciQuantita);
                    pst3.executeUpdate();
                }
                else if(((int)Integer.parseInt(array[2]) % Integer.parseInt(periodo) != 0)){
                    String idContratto = rs.getString("f.idContratto");
                    String idFarmaco = rs.getString("f.idFarmaco");
                    String cambiaStato = "UPDATE farmacocontratto SET spedito = 0 WHERE idContratto = '"+idContratto+"' AND idFarmaco = '"+idFarmaco+"'";
                    PreparedStatement pst2 = connessione.prepareStatement(cambiaStato);
                    pst2.executeUpdate();
                }
            }
            rs.close();
            st.close();
        }
        catch(SQLException | ParseException ex){
        }
    }
}
