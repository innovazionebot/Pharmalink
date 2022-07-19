package Farmacista;

public class ID_Ordine {
    static String idOrdine;
    public ID_Ordine(String a){
        idOrdine = a;
    }
    public static String getID() {
        return idOrdine;
    }
}
