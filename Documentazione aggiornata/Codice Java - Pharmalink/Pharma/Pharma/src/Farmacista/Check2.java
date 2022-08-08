package Farmacista;

public class Check2 {
    private String idFarmaco, nome, principio, dataScadenza, quantita;

    public Check2(String idFarmaco, String nome, String principio, String dataScadenza, String quantita) {
        this.nome = nome;
        this.principio = principio;
        this.dataScadenza = dataScadenza;
        this.quantita = quantita;
        this.idFarmaco = idFarmaco;
    }

    public String getIdFarmaco(){
        return idFarmaco;
    }
    
    public String getNome() {
        return nome;
    }

    public String getPrincipio() {
        return principio;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public String getQuantita() {
        return quantita;
    }
    
}
