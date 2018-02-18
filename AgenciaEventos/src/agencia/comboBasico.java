
package agencia;


public class comboBasico {
    
    private    String  descripcion,estado,cantidad,precio;

    public comboBasico(String descripcion, String estado, String cantidad, String precio) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public comboBasico() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getPrecio() {
        return precio;
    }
       
    
    
}
