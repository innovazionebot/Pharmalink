package CredenzialiUtente;

public class CredenzialiUtente {
    static String id, nome, cognome;
    public CredenzialiUtente(String idUtente, String nomeUtente, String cognomeUtente){
        id = idUtente;
        nome = nomeUtente;
        cognome = cognomeUtente;
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
}