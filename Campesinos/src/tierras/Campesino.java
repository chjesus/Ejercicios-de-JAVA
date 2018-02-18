
package tierras;

public abstract class Campesino {
    private String nombre;
    private String cedula;
    private int edad;
    protected String situacionSocial;

    public Campesino() {
    }

    public Campesino(String nombre, String cedula, int edad, String situacionSocial) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.situacionSocial = situacionSocial;
    }
    public abstract void determinar_situacion_social();
    
    public void imprimir(){
        System.out.print("Nombre: "+nombre+" Cedula: "+cedula+" Situacion: "+situacionSocial);
    }
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getSituacionSocial() {
        return situacionSocial;
    } 
}
