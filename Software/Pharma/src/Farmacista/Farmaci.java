/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmacista;

/**
 *
 * @author salva
 */
class Farmaci {
    private String nome, principio, quantita, periodo;
    public Farmaci(String nome, String principio, String quantita, String periodo){
        this.nome = nome;
        this.principio = principio;
        this.quantita = quantita;
        this.periodo = periodo;
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
    
    public String getPeriodo(){
        return periodo;
    }
}
