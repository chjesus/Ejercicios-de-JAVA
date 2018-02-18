
package Aerolinea;

public class Pasajero extends Persona{
    String numAsiento;      /*Almacena el Nro de Identificacion Del Asiento*/
    int valorPasaje;        /*Almacena el costo en Bs del pasaje*/

    public Pasajero() {
        super();
    }

    public Pasajero(int id, String nombre, int edad, int vuelo, String categoria, String numAsiento, int valorPasaje) {
        super(id, nombre, edad, vuelo, categoria);
        this.numAsiento = numAsiento;
        this.valorPasaje = valorPasaje;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public int getValorPasaje() {
        return valorPasaje;
    }

    @Override
    public void Mostrar() {
        System.out.println("Nombre: "+nombre+" Edad: "+edad+" Categoria: "+categoria);
    }

    @Override
    public void CalcularCategoria() {
        if(valorPasaje<350){
            this.categoria="Economica";
        }else if(valorPasaje>351 && valorPasaje<500){
            this.categoria="Convenio";
        }else if(valorPasaje>500){
            this.categoria="1era Clase";
        }
    }
    
}
