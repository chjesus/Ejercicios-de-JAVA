
package confidencial;

public abstract class agentes {
    private String nombre;
    private String apellido;
    private String cedula;

    public agentes(){
        nombre="";
        apellido="";
        cedula="";
    }
    public agentes(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    public int suma_cedula(){
        int ced=0;
        for (int i = 0; i < cedula.length(); i++) {
            ced=Integer.parseInt(""+cedula.charAt(i));
            ced+=ced;
        }
        return ced;
    }
    public abstract boolean palindromo_regular();
    public abstract boolean cadena_espejo();
    public abstract boolean palindromo_espejo();
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
