package Farmacista;

public class CheckOrdiniDaConfermare {
    private String idOrdine, dataConsegna;
    public CheckOrdiniDaConfermare(String idOrdine, String dataConsegna){
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
