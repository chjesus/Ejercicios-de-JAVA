
package agencia;


public abstract class Evento {
    
    
     String representante, fecha_evento, direccion, confirmacion, monto_pagar;

    public comboBasico[] getRubrosBasicos() {
        return rubrosBasicos;
    }
     public comboBasico getRubrosBasicos(int i) {
        return rubrosBasicos[i];
    }
        comboBasico rubrosBasicos[];

         public Evento() {
         }

    public Evento(String representante, String fecha_evento, String direccion, String confirmacion, String monto_pagar) {
        rubrosBasicos=new comboBasico[4];
        this.representante = representante;
        this.fecha_evento = fecha_evento;
        this.direccion = direccion;
        this.confirmacion = confirmacion;
        this.monto_pagar = monto_pagar;
       
    }
     
    public String getRepresentante() {
        return representante;
    }
    

    public String getFecha_evento() {
        return fecha_evento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setMonto_pagar(String monto_pagar) {
        this.monto_pagar = monto_pagar;
    }
  
    public String getConfirmacion() {
        return confirmacion;
    }

    public String getMonto_pagar() {
        return monto_pagar;
    }
    
     abstract void calcular_pago_evento() ;
    
}
