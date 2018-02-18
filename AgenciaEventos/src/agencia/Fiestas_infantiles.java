
package agencia;

public class Fiestas_infantiles extends Evento{
    
    String  motivo_fiesta;
      int cant_animadores;
    public Fiestas_infantiles(int cant_animadores, String motivo_fiesta, String representante, String fecha_evento, String direccion, String confirmacion, String monto_pagar) {
        super(representante, fecha_evento, direccion, confirmacion, monto_pagar);
        this.cant_animadores = cant_animadores;
        this.motivo_fiesta = motivo_fiesta;
    }

    public Fiestas_infantiles() {
    }
   
    public int getCant_animadores() {
        return cant_animadores;
    }

    public String getMotivo_fiesta() {
        return motivo_fiesta;
    }

    
    
    void calcular_pago_evento() {
        super.setMonto_pagar(""+(cant_animadores*6000));
        
    }
    
    
}
