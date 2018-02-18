/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tierras;

/**
 *
 * @author USUARIO
 */
public class Agricultor extends Campesino{
    private int altTerreno;
    private int anchoTerreno;
    private String tipoVegetal;
    private int cantVegetal;
    private int valorUnitVegetal;

    public Agricultor(String nombre, String cedula, int edad, String situacionSocial, int altTerreno, int anchoTerreno, String tipoVegetal, int cantVegetal, int valorUnitVegetal) {
        super(nombre, cedula, edad, situacionSocial);
        this.altTerreno = altTerreno;
        this.anchoTerreno = anchoTerreno;
        this.tipoVegetal = tipoVegetal;
        this.cantVegetal = cantVegetal;
        this.valorUnitVegetal = valorUnitVegetal;
    }

    public int getAltTerreno() {
        return altTerreno;
    }

    public int getAnchoTerreno() {
        return anchoTerreno;
    }

    public String getTipoVegetal() {
        return tipoVegetal;
    }

    public int getCantVegetal() {
        return cantVegetal;
    }

    public int getValorUnitVegetal() {
        return valorUnitVegetal;
    }
    
    public int calcular_ganancia(){
        int Total;
        Total=cantVegetal*valorUnitVegetal;
        return Total;
    }
    @Override
    public void determinar_situacion_social() {
        int TotalGanancia;
        TotalGanancia = cantVegetal*valorUnitVegetal;
        
        if(TotalGanancia>5000){
            super.situacionSocial="Elevada";
        }else if(TotalGanancia<5000){
            super.situacionSocial="Normal";
        }
        System.out.println(""+situacionSocial);
    } 
}
