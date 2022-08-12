package CredenzialiUtente;

public class CredenzialiUtente {
    static String id, nome, cognome, idContratto;
    public CredenzialiUtente(String idUtente, String nomeUtente, String cognomeUtente, String idC){
        id = idUtente;
        nome = nomeUtente;
        cognome = cognomeUtente;
        idContratto = idC;
    }
    
    public static String getId(){
        return id;
    }
    
    public static String getNome(){
        return nome;
    }
    
    public static String getCognome(){
        return cognome;
    }
    
    public static String getIdContratto(){
        return idContratto;
    } 
}