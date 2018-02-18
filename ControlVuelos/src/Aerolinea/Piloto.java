
package Aerolinea;

public class Piloto extends Persona{
    int horas; /*Almacena Nro de horas de vuelo*/

    public Piloto(int id, String nombre, int edad, int vuelo, String categoria, int horas) {
        super(id, nombre, edad, vuelo, categoria);
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }
    
    @Override
    public void Mostrar() {
        System.out.println("Nombre: "+nombre+" Edad: "+edad+" Categoria: "+categoria);
    }

    @Override
    public void CalcularCategoria() {
        if(horas>1500){
            this.categoria="Capitan";
        }
        if(horas<=1500){
            this.categoria="1er Piloto";
        }
    }
}
