package Fattorino;

public class Ordini {
    private String idOrdine, nome, cognome, indirizzo;
    public Ordini(String idOrdine, String nome, String cognome, String indirizzo){
        this.idOrdine = idOrdine;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
    }
    public String getIdOrdine() {
        return idOrdine;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

}
