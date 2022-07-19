package Farmacista;

class Contratti {
    private String idContratto, idUtente, periodo;
    public Contratti(String idContratto, String idUtente, String periodo){
        this.idContratto = idContratto;
        this.idUtente = idUtente;
        this.periodo = periodo;
    }
    
    public String getIdContratto(){
        return idContratto;
    }
    
    public String getIdUtente(){
        return idUtente;
    }
    
    public String getPeriodo(){
        return periodo;
    }
}
