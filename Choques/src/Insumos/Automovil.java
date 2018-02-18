
package Insumos;

public class Automovil extends Vehiculo implements Valores{
    
    double masaNeta;
    
    public Automovil(String marca, String modelo, int id, double masaNeta) {
        super(marca, modelo, id);
        this.masaNeta = masaNeta*1000;
    }

    public double getMasaNeta() {
        return masaNeta;
    }

    @Override
    public double masaTotal() {
        double total;
            total=masaNeta+(5*masaPuestos)+(0*masaCargas);
        return total;
    }
    
}
