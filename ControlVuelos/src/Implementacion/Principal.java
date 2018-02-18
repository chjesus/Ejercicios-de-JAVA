
package Implementacion;

import Aerolinea.Pasajero;
import Aerolinea.Persona;
import Aerolinea.Vuelos;
import data.Datos;

public class Principal {
    Vuelos[] viajes; 
    Persona[] viajeros;
    
    public void cargarDatos(){
        int NroV=Datos.datos_vuelos.length;
        int NroP=Datos.datos_persona.length;
        
        /*Separar y Cargar Datos de Vuelos*/
        String vNombre[] = new String[NroV];
        String vNroVuelo[] = new String[NroV];
        String vDestino[] = new String[NroV];
        String aux[] = new String[NroV];
        
        viajeros = new Persona[NroP];
            viajes = new Vuelos[NroV];
        
        for (int i = 0; i < viajes.length; i++) {
            aux=Datos.datos_vuelos[i].split(";");
            vNombre[i]=aux[0];
            vNroVuelo[i]=aux[1];
            vDestino[i]=aux[2];
            
            viajes[i] = new Vuelos(vNombre[i],Integer.parseInt(vNroVuelo[i]),vDestino[i]);
        }
        /*Separar y Cargar Datos de Personas*/
        String Id[] = new String[NroP];
        String Nombre[] = new String[NroP];
        String Edad[] = new String[NroP];
        String NroVuelo[] = new String[NroP];
        String CodigoInd[] = new String[NroP];
        
        /*Codigo si es 1*/
        String NroAsientos[] = new String[NroP];
        String ValorPasaje[] = new String[NroP];
        
        /*Codigo si es 2*/
        String Estatura[] = new String[NroP];
        String CanIdiomas[] = new String[NroP];
        
        /*Codigo si es 3*/
        String HorasV[] = new String[NroP];
        
        int AuxCodig;
        String Aux[] = new String[NroP];
        for (int i = 0; i < viajeros.length; i++) {
            Aux=Datos.datos_persona[i].split(";");
            
            Id[i]=Aux[0];
            Nombre[i]=Aux[1];
            Edad[i]=Aux[2];
            NroVuelo[i]=Aux[3];
            CodigoInd[i]=Aux[4];
            AuxCodig=Integer.parseInt(CodigoInd[i]);
                if(AuxCodig==1){
                    NroAsientos[i]=Aux[5];
                    ValorPasaje[i]=Aux[6];
                    viajeros[i] = new Pasajero(Integer.parseInt(Id[i]),Nombre[i],Integer.parseInt(Edad[i]),Integer.parseInt(NroVuelo[i]),"",NroAsientos[i],Integer.parseInt(ValorPasaje[i])); 
                }
                if(AuxCodig==2){
                    Estatura[i]=Aux[5];
                    CanIdiomas[i]=Aux[6];
                }
                if(AuxCodig==3){
                    HorasV[i]=Aux[5];
                }
        }
    }
    public static void main(String[] args) {
       
    }
    
}
