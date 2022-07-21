/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmacista;

/**
 *
 * @author salva
 */
public class CheckOrdiniDaConfermare {
    private String idOrdine, dataConsegna;
    public CheckOrdiniDaConfermare(String idOrdine, String dataConsegna){
        this.dataConsegna = dataConsegna;
        this.idOrdine = idOrdine;
    }

    public String getIdOrdine() {
        return idOrdine;
    }

    public String getDataConsegna() {
        return dataConsegna;
    }
    
}
