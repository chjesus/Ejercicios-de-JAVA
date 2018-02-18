
package Aerolinea;

public class Vuelos {
    private String nombre;  /*Nombre de la Aerolinea*/
    private int vuelo;      /*Numero de Vuelo*/
    private String destino; /*Destino*/

    public Vuelos(String nombre, int vuelo, String destino) {
        this.nombre = nombre;
        this.vuelo = vuelo;
        this.destino = destino;
    }
    
    public void Mostrar(){
        System.out.println("Aerolinea: "+nombre+" Numero de Vuelo: "+vuelo+" Destino: "+destino);
    }

    public String getNombre() {
        return nombre;
    }

    public int getVuelo() {
        return vuelo;
    }

    public String getDestino() {
        return destino;
    }
    
}
