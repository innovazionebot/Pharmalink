package Farmacista;

public class Catalogo_ModificaOrdine {
    private String idOrdine, idFarmaco, nomeFarmaco, principioFarmaco, scadenzaFarmaco, dataConsegna, qDisponibili, qAttuale;

    public Catalogo_ModificaOrdine(String idOrdine, String idFarmaco, String nomeFarmaco, String principioFarmaco, String scadenzaFarmaco, String dataConsegna, String qDisponibili, String qAttuale) {
        this.idOrdine = idOrdine;
        this.idFarmaco = idFarmaco;
        this.nomeFarmaco = nomeFarmaco;
        this.principioFarmaco = principioFarmaco;
        this.scadenzaFarmaco = scadenzaFarmaco;
        this.dataConsegna = dataConsegna;
        this.qDisponibili = qDisponibili;
        this.qAttuale = qAttuale;
    }

    public String getIdOrdine() {
        return idOrdine;
    }

    public String getIdFarmaco() {
        return idFarmaco;
    }

    public String getNomeFarmaco() {
        return nomeFarmaco;
    }

    public String getPrincipioFarmaco() {
        return principioFarmaco;
    }

    public String getScadenzaFarmaco() {
        return scadenzaFarmaco;
    }

    public String getDataConsegna() {
        return dataConsegna;
    }

    public String getqDisponibili() {
        return qDisponibili;
    }

    public String getqAttuale() {
        return qAttuale;
    }
    
    
}
