package Farmacista;

public class Catalogo_ModificaOrdine {
    private String idOrdine, idFarmaco, nome, principio, scadenza, disponibili, dataConsegna, quantitaAttuale;
    public Catalogo_ModificaOrdine(String idOrdine, String idFarmaco, String nome, String principio, String scadenza, String disponibili, String dataConsegna, String quantitaAttuale){
        this.nome = nome;
        this.principio = principio;
        this.disponibili = disponibili;
        this.scadenza = scadenza;
        this.idFarmaco = idFarmaco;
        this.quantitaAttuale = quantitaAttuale;
        this.idOrdine = idOrdine;
        this.dataConsegna = dataConsegna;
    }

    public String getDataConsegna() {
        return dataConsegna;
    }
    
    public String getIdOrdine() {
        return idOrdine;
    }

    public String getQuantitaAttuale() {
        return quantitaAttuale;
    }
    
    public String getIDOrdine(){
        return idOrdine;
    }
    
    public String getIdFarmaco(){
        return idFarmaco;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getPrincipio(){
        return principio;
    }
    
    public String getScadenza(){
        return scadenza;
    }
    
    public String getDisponibili(){
        return disponibili;
    }
}
