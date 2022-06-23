package Farmacista;

public class Check2 {
    private String nome, principio, dataScadenza, quantita;

    public Check2(String nome, String principio, String dataScadenza, String quantita) {
        this.nome = nome;
        this.principio = principio;
        this.dataScadenza = dataScadenza;
        this.quantita = quantita;
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
