package Magazziniere;

class Catalogo {
    private String idFarmaco, nome, principio, scadenza, quantita, periodoProduzione;
    public Catalogo(String idFarmaco, String nome, String principio, String scadenza, String quantita, String periodoProduzione){
        this.nome = nome;
        this.principio = principio;
        this.quantita = quantita;
        this.scadenza = scadenza;
        this.idFarmaco = idFarmaco;
        this.periodoProduzione = periodoProduzione;
    }

    public String getPeriodoProduzione() {
        return periodoProduzione;
    }
    
    public String getNomeFarmaco(){
        return nome;
    }
    
    public String getPrincipio(){
        return principio;
    }
    
    public String getQuantita(){
        return quantita;
    }
    
    public String getScadenza(){
        return scadenza;
    }
    
    public String getIdFarmaco(){
        return idFarmaco;
    }
}
