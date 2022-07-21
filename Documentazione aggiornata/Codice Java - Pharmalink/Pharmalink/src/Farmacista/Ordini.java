package Farmacista;

public class Ordini {
    private String idOrdine, dataOrdine, dataConsegna, stato;
    public Ordini(String idOrdine, String dataOrdine, String dataConsegna, String stato){
        this.idOrdine = idOrdine;
        this.dataOrdine = dataOrdine;
        this.dataConsegna = dataConsegna;
        this.stato = stato;
    }

    public String getIdOrdine() {
        return idOrdine;
    }

    public String getDataOrdine() {
        return dataOrdine;
    }
    
    public String getDataConsegna() {
        return dataConsegna;
    }
    public String getStato() {
        return stato;
    }
    
    public void setIdOrdine(String id){
        this.idOrdine = id;
    }
}
