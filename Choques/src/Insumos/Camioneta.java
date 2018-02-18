
package Insumos;

public class Camioneta extends Vehiculo implements Valores{

    double masaNeta;
    
    public Camioneta(String marca, String modelo, int id, double masaNeta) {
        super(marca, modelo, id);
        this.masaNeta = masaNeta*1000;
    }

    public double getMasaNeta() {
        return masaNeta;
    }

    @Override
    public double masaTotal() {
        double total;
            total=masaNeta+(2*masaPuestos)+(20*masaCargas);
        return total;
    }
    
}
