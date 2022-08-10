package Farmacista;

public class ListaOrdiniModificabili {
    private String idOrdine, dataConsegna;
    public ListaOrdiniModificabili(String idOrdine, String dataConsegna){
        this.dataConsegna = dataConsegna;
        this.idOrdine = idOrdine;
    }

    public String getIdOrdine() {
        return idOrdine;
    }

    public String getDataConsegna() {
        return dataConsegna;
    }
    
}
