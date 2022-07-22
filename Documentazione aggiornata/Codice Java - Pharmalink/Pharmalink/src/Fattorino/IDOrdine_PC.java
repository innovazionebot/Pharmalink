package Fattorino;

public class IDOrdine_PC {
    static String idOrdine;
    public IDOrdine_PC(String a){
        idOrdine = a;
    }
    public static String getIdOrdine() {
        return idOrdine;
    }
    
    public String toString(){
        return idOrdine;
    }
}
