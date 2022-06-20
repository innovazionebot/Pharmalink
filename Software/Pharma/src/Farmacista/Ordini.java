/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmacista;

/**
 *
 * @author salva
 */
public class Ordini {
    private String idOrdine, quantita;
    public Ordini(String idOrdine, String quantita){
        this.idOrdine = idOrdine;
        this.quantita = quantita;
    }

    public String getIdOrdine() {
        return idOrdine;
    }

    public String getQuantita() {
        return quantita;
    }
}
