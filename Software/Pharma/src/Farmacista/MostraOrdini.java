package Farmacista;

import IndirizzoIP.IndirizzoIP;
import com.mysql.cj.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MostraOrdini {
        private String id, idContratto;
        public Connection getConnection(){
            Connection con = null;
        try{
            IndirizzoIP address = new IndirizzoIP();
            String url = "jdbc:mysql://" + address.ip + "/";
            String dbName = "pharmalinkazienda";
            String driver = "com.mysql.cj.jdbc.Driver";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url+dbName, username, password);
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
        }
        public HashMap<String, String> populateCombo(){
            HashMap<String, String> map = new HashMap<String, String>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;
            try {
                id = CheckID.getID();
                st = con.createStatement();
                rs = st.executeQuery("SELECT f.idOrdine, f.id from farmacoordine f INNER JOIN ordine o ON f.idOrdine = o.idOrdine AND o.idUtente = '"+id+"'");
                ModOrdini cmi;
            while(rs.next()){
               cmi = new ModOrdini(rs.getString("f.idOrdine"), rs.getString("f.id"));
               map.put(cmi.getIdOrdine(), cmi.getId());
            }
            } catch (SQLException ex) {
           Logger.getLogger(MostraOrdini.class.getName()).log(Level.SEVERE, null, ex);
            }
            return map;
        }
}
