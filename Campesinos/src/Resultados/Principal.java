
package Resultados;



import info.Informacion;
import tierras.Agricultor;
import tierras.Campesino;
import tierras.Ganadero;
import tierras.Puericultor;

public class Principal {
    
    Campesino trabajador_campo[];
    int nCamp = Informacion.datos_campesinos.length;
    int nInfo = Informacion.info_agricola.length;
    int nInfoGan = Informacion.info_ganado.length;
    
    public void cargarInfo(){
        trabajador_campo = new Campesino[nCamp];
        
        /*Datos de Campesinos*/
        String aux[] = new String[nCamp];
        
        String nombre[] = new String[nCamp]; 
        String cedula[] = new String[nCamp];
        String edad[] = new String[nCamp];
        int tipo[] = new int[nCamp];
        String zona[] = new String[nCamp];
        
        /*Datos de Agricola*/
        String aux_2[] = new String[nInfo];
        
        String auxCedula[] = new String[nInfo];
        String altTerreno[] = new String[nInfo];
        String ancTerreno[] = new String[nInfo];
        String vegCultiva[] = new String[nInfo];
        String cantVegetal[] = new String[nInfo];
        String precUnitVeg[] = new String[nInfo];
        
        /*Datos de Ganado*/
        String aux_3[] = new String[nInfoGan];
        
        String auxCed[] = new String[nInfoGan];
        String cantCabeza[] = new String[nInfoGan];
        String precCabeza[] = new String[nInfoGan];
        
        for (int i = 0; i < nCamp; i++) {
            aux=Informacion.datos_campesinos[i].split("-");
            nombre[i]=aux[0];
            cedula[i]=aux[1];
            edad[i]=aux[2];
            tipo[i]=Integer.parseInt(aux[3]);
            
                for (int j = 0; j < nInfo; j++) {
                    aux_2=Informacion.info_agricola[j].split("-");
                    auxCedula[j]=aux_2[0];
                    altTerreno[j]=aux_2[1];
                    ancTerreno[j]=aux_2[2];
                    vegCultiva[j]=aux_2[3];
                    cantVegetal[j]=aux_2[4];
                    precUnitVeg[j]=aux_2[5];
                }
                for (int k = 0; k < nInfoGan; k++) {
                    aux_3=Informacion.info_ganado[k].split("-");
                    auxCed[k]=aux_3[0];
                    cantCabeza[k]=aux_3[1];
                    precCabeza[k]=aux_3[2];
                }
                if(tipo[i]==1){
                    for (int j = 0; j < nInfo; j++) {
                        if(cedula[i].equals(auxCedula[j])){
                            trabajador_campo[i] = new Agricultor(nombre[i],cedula[i],Integer.parseInt(edad[i]),"",Integer.parseInt(altTerreno[j]),Integer.parseInt(ancTerreno[j]),vegCultiva[j],Integer.parseInt(cantVegetal[j]),Integer.parseInt(precUnitVeg[j]));
                        }
                    }
                }else if(tipo[i]==2){
                    zona[i]=aux[4];
                        trabajador_campo[i] = new Puericultor(nombre[i],cedula[i],Integer.parseInt(edad[i]),"",zona[i]);
                }else if(tipo[i]==3){
                    for (int j = 0; j < nInfoGan; j++) {
                        if(cedula[i].equals(auxCed[j])){
                            trabajador_campo[i] = new Ganadero(nombre[i],cedula[i],Integer.parseInt(edad[i]),"",Integer.parseInt(cantCabeza[j]),Integer.parseInt(precCabeza[j]));
                        }
                    }
                }
        }
        /*for (int i = 0; i < nCamp; i++) {
            System.out.println("Nombre: "+tipo[i]);
        }*/
        /*for (int i = 0; i < nInfo; i++) {
            System.out.println("Cedula: "+auxCedula[i]);
        }*/
    }
    
    public void ganadero_exitoso(){
        double var;
        double mayor=0;
        int a=0;
        for (int i = 0; i < trabajador_campo.length; i++) {
            if(trabajador_campo[i] instanceof Ganadero){
               var = ((Ganadero)trabajador_campo[i]).calcular_ganancia();
               if(var>mayor){
                   mayor=var;
                   a=i;
               }
            }
        }
        System.out.println("-----Ganador por Mayor venta de Cabeza de ganado-----");
        System.out.println("Nombre: "+((Ganadero)trabajador_campo[a]).getNombre()+" Cedula: "+((Ganadero)trabajador_campo[a]).getCedula());
    }
    public void agricultor_mayor_tierra(){
        int totalMetros=0;
        int mayor=0;
        int a=0;
        for (int i = 0; i < trabajador_campo.length; i++) {
            if(trabajador_campo[i] instanceof Agricultor){
                if(((Agricultor)trabajador_campo[i]).calcular_ganancia()>mayor){
                    mayor=((Agricultor)trabajador_campo[i]).calcular_ganancia();
                    totalMetros=((Agricultor)trabajador_campo[i]).getAltTerreno()*((Agricultor)trabajador_campo[i]).getAnchoTerreno();
                    a=i;   
                }
            }
        }
        System.out.println("-----Ganador por mayor Ganancia-----");
        System.out.println("Nombre: "+((Agricultor)trabajador_campo[a]).getNombre()+" Total Metros^2: "+totalMetros);
    }
    
    public void reparticion(){
        System.out.println("-------------Listado-------------");
        for (int i = 0; i < trabajador_campo.length; i++) {
            ((Campesino)trabajador_campo[i]).imprimir();
            ((Campesino)trabajador_campo[i]).determinar_situacion_social();
        }
    }
    public static void main(String[] args) {
        Principal leer = new Principal();
        leer.cargarInfo();
        leer.ganadero_exitoso();
        leer.agricultor_mayor_tierra();
        leer.reparticion();
    }
}
