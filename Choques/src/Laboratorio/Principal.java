
package Laboratorio;

import Insumos.Autobus;
import Insumos.Automovil;
import Insumos.Camioneta;
import Insumos.Vehiculo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
    Vehiculo[] vehiculos = new Vehiculo[11];
    Experimento[] experimento = new Experimento[11];
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    
    public void cargarDatosVehiculos() throws FileNotFoundException, IOException{
        String archivo="Vehiculos.txt";
        String linea;
        String[] auxData = new String[11];
        String[] auxArchivo;
        int cont=0;
        BufferedReader leer = new BufferedReader(new FileReader(archivo));
        linea=leer.readLine();
        int a=0; 
        
        while(linea!=null){
            auxData[a]=linea;
            a++;
            linea=leer.readLine();
            cont++;
        }leer.close();
        
                /*Variables*/
        int[] tipo = new int[cont];
        String[] marca = new String[cont];
        String[] modelo = new String[cont];
        double[] masa = new double[cont];
        int[] id = new int[cont];
        
        for (int i = 0; i < cont; i++) {
            auxArchivo=auxData[i].split("-");
            tipo[i]=Integer.parseInt(auxArchivo[0]);
            marca[i]=auxArchivo[1];
            modelo[i]=auxArchivo[2];
            masa[i]=Double.parseDouble(auxArchivo[3]);
            id[i]=Integer.parseInt(auxArchivo[4]);
            
            if(tipo[i]==1){
                vehiculos[i] = new Automovil(marca[i],modelo[i],id[i],masa[i]);
            }
            if(tipo[i]==2){
                vehiculos[i] = new Camioneta(marca[i],modelo[i],id[i],masa[i]);
            }
            if(tipo[i]==3){
                vehiculos[i] = new Autobus(marca[i],modelo[i],id[i],masa[i]);
            }
        }
    }
    
    public void cargarDatosExperimentos() throws FileNotFoundException, IOException{
        String archivo="Experimentos.txt";
        String linea;
        String[] auxData = new String[11];
        String[] auxArchivo;
        String[] auxArchivo_1;
        int cont=0;
        BufferedReader leer = new BufferedReader(new FileReader(archivo));
        linea=leer.readLine();
        int a=0; 
        
        while(linea!=null){
            auxData[a]=linea;
            a++;
            linea=leer.readLine();
            cont++;
        }leer.close();
        
        String[] vehi_1 = new String[cont];
        int[] id_vehi_1 = new int[cont];
        int[] vel_vehi_1 = new int[cont];
        String[] vehi_2 = new String[cont];
        int[] id_vehi_2 = new int[cont];
        int[] vel_vehi_2 = new int[cont];
        

        for (int i = 0; i < cont; i++) {
            auxArchivo=auxData[i].split(";");
            vehi_1[i]=auxArchivo[0];
            vehi_2[i]=auxArchivo[1];
            auxArchivo_1=vehi_1[i].split("-");
            id_vehi_1[i]=Integer.parseInt(auxArchivo_1[0]);
            vel_vehi_1[i]=Integer.parseInt(auxArchivo_1[1]);
            auxArchivo_1=vehi_2[i].split("-");
            id_vehi_2[i]=Integer.parseInt(auxArchivo_1[0]);
            vel_vehi_2[i]=Integer.parseInt(auxArchivo_1[1]);
            
            for (int k = 0; k < cont; k++) {
                if(id_vehi_1[i]==vehiculos[k].getId()){
                    Cuerpo cuerpo1 = new Cuerpo(vel_vehi_1[i],vehiculos[k]);
                        for (int m = 0; m < cont; m++) {
                            if(id_vehi_2[i]==vehiculos[m].getId()){
                                Cuerpo cuerpo2 = new Cuerpo(vel_vehi_2[i],vehiculos[m]);
                                experimento[i]=new Experimento(cuerpo1,cuerpo2);
                                break;
                            }
                    }
                        break;
                }
            }
        }

    }
    public void EjecutarExperimento(){
        for (int i = 0; i < experimento.length; i++) {
            experimento[i].imprimirExperimento(i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        Principal leer = new Principal();
        leer.cargarDatosVehiculos();
        leer.cargarDatosExperimentos();
        leer.EjecutarExperimento();
    }
    
}
