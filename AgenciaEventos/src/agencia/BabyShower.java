
package agencia;


public class BabyShower extends Evento{
    
     int  cant_juegos;

    public int getCant_juegos() {
        return cant_juegos;
    }

    public BabyShower(int cant_juegos, String representante, String fecha_evento, String direccion, String confirmacion, String monto_pagar) {
        super(representante, fecha_evento, direccion, confirmacion, monto_pagar);
        this.cant_juegos = cant_juegos;
    }

    public BabyShower() {
    }

   
    void calcular_pago_evento() {
         super.setMonto_pagar(""+(cant_juegos*15000));
      
    }
      
    
    
    
    
}
