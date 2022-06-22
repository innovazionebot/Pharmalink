package Farmacista;

public class ModOrdini {
    private String idOrdine, id;
    public ModOrdini(String idOrdine, String id){
        this.idOrdine = idOrdine;
        this.id = id;
    }
    public void setIdOrdine(String id){
        this.idOrdine = id;
    }
    
    public void setId(String i){
        this.id = i;
    }

    public String getIdOrdine() {
        return idOrdine;
    }
    
    public String getId(){
        return id;
    }

}
