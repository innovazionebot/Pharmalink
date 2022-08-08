package Farmacista;

public class CheckContratto {
    static String idContratto;
    public CheckContratto(String a){
        idContratto = a;
    }
    public static String getID() {
        return idContratto;
    }
}
