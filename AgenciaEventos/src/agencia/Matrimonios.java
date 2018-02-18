
package agencia;

public class Matrimonios extends Evento {
    
    String  nombre_iglesia;
          int  cant_canciones;

    public Matrimonios(String nombre_iglesia, int cant_canciones, String representante, String fecha_evento, String direccion, String confirmacion, String monto_pagar) {
        super(representante, fecha_evento, direccion, confirmacion, monto_pagar);
        this.nombre_iglesia = nombre_iglesia;
        this.cant_canciones = cant_canciones;
    }

    public Matrimonios() {
    }

     
    void calcular_pago_evento() {
        
       super.setMonto_pagar(""+(cant_canciones*80000));
    }

    public String getNombre_iglesia() {
        return nombre_iglesia;
    }

    public int getCant_canciones() {
        return cant_canciones;
    }
    
    
}
