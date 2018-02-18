
package Aerolinea;

public abstract class Persona {
    int id;             /*Nro de identificacion*/
    String nombre;      /*Nombre de la persona*/
    int edad;           /*Edad de la persona*/
    int vuelo;          /*Numero de vuelo de la persona*/
    String categoria;   /*Categoria de la persona*/
    
    public Persona(){
        
    }
    public Persona(int id, String nombre, int edad, int vuelo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.vuelo = vuelo;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getVuelo() {
        return vuelo;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public abstract void Mostrar();
    public abstract void CalcularCategoria();
    
}
