package Magazziniere;

public class Ordini {
    private String idOrdine, dataOrdine, dataConsegna, stato, nome, cognome, note;
    public Ordini(String idOrdine, String dataOrdine, String dataConsegna, String stato, String nome, String cognome, String note){
        this.idOrdine = idOrdine;
        this.dataOrdine = dataOrdine;
        this.dataConsegna = dataConsegna;
        this.stato = stato;
        this.nome = nome;
        this.cognome = cognome;
        this.note = note;
    }

    public String getNote(){
        return note;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
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
