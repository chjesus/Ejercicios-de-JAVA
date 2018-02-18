
package Laboratorio;

import Insumos.Autobus;
import Insumos.Automovil;
import Insumos.Camioneta;
import Insumos.Vehiculo;

public class Cuerpo {
    double velocidad; //expresada en M/S estraer del archivo experimentos.txt
    Vehiculo vehiculo;

    public Cuerpo(double velocidad, Vehiculo vehiculo) {
        this.velocidad = (velocidad*1000)/3600;
        this.vehiculo = vehiculo;
    }

    public double getVelocidad() {
        return velocidad;
    }
    
    public String toString(){
        String tipo="";
        if(vehiculo instanceof Automovil){
            tipo="Automovil";
        }
        if(vehiculo instanceof Camioneta){
            tipo="Camioneta";
        }
        if(vehiculo instanceof Autobus){
            tipo="Autobus";
        }
        String mensaje="Vehiculo: "+tipo+" Marca: "+this.vehiculo.getMarca()+" Modelo: "+this.vehiculo.getModelo()+" Velocidad: "+velocidad+" m/s Masa: "+getMasa()+"Kg";
        return mensaje;
    }
    public double calcularsCantMov(){
        double p=0.0; //cantidad de movimiento

        if(vehiculo instanceof Automovil){
            p = ((Automovil)vehiculo).getMasaNeta()*getVelocidad();
        }
        if(vehiculo instanceof Camioneta){
            p = ((Camioneta)vehiculo).getMasaNeta()*getVelocidad();
        }  
        if(vehiculo instanceof Autobus){
            p = ((Autobus)vehiculo).getMasaNeta()*getVelocidad();
        } 
        return p;
    }
    public double CalcularEnergiaMec(){
       double energiaM=0.0;
       
       
       if(vehiculo instanceof Automovil){
           energiaM = (((Automovil)vehiculo).getMasaNeta()*(getVelocidad()*getVelocidad()))/2;
       }
       if(vehiculo instanceof Camioneta){
           energiaM = (((Camioneta)vehiculo).getMasaNeta()*(getVelocidad()*getVelocidad()))/2;
       }
       if(vehiculo instanceof Autobus){
           energiaM = (((Autobus)vehiculo).getMasaNeta()*(getVelocidad()*getVelocidad()))/2;
       }
       return energiaM;
    }
    public double getMasa(){
        double masaTotal=0.0;
        
            if(vehiculo instanceof Automovil){
                masaTotal=((Automovil)vehiculo).getMasaNeta();
            }
            if(vehiculo instanceof Camioneta){
                masaTotal=((Camioneta)vehiculo).getMasaNeta();
            }
            if(vehiculo instanceof Autobus){
                masaTotal=((Autobus)vehiculo).getMasaNeta();
            }
        return masaTotal;
    }
}
