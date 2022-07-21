/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmacista;

/**
 *
 * @author salva
 */
class Catalogo_OrdinaFarmaco {
    private String idFarmaco, nome, principio, scadenza, quantita;
    public Catalogo_OrdinaFarmaco(String idFarmaco, String nome, String principio, String scadenza, String quantita){
        this.nome = nome;
        this.principio = principio;
        this.quantita = quantita;
        this.scadenza = scadenza;
        this.idFarmaco = idFarmaco;
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
