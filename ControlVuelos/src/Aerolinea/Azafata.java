
package Aerolinea;

public class Azafata extends Persona{
    double altura; /*Almacena estatura de azafata*/
    int idiomas;   /*cantidad de idiomas que habla la azafata*/

    public Azafata(int id, String nombre, int edad, int vuelo, String categoria, double altura, int idiomas) {
        super(id, nombre, edad, vuelo, categoria);
        this.altura = altura;
        this.idiomas = idiomas;
    }

    public double getAltura() {
        return altura;
    }

    public int getIdiomas() {
        return idiomas;
    }

    @Override
    public void Mostrar() {
        System.out.println("Nombre: "+nombre+" Edad: "+edad+" Categoria: "+categoria);
        System.out.println("Estatura: "+altura+" Idiomas: "+idiomas);
    }

    @Override
    public void CalcularCategoria() {
        if(edad<22 && idiomas<=2){
            this.categoria="Aprendiz";
        }
        if(edad>=22 && idiomas<=2){
            this.categoria="Auxiliar";
        }
        if(idiomas>2){
            this.categoria="Titular";
        }
    }
}
