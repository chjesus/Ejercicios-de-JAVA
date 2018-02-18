
package Insumos;

public class Autobus extends Vehiculo implements Valores{

    double masaNeta;
    
    public Autobus(String marca, String modelo, int id, double masaNeta) {
        super(marca, modelo, id);
        this.masaNeta = masaNeta*1000;
    }

    public double getMasaNeta() {
        return masaNeta;
    }

    @Override
    public double masaTotal() {
         double total;
            total=masaNeta+(32*masaPuestos)+(16*masaCargas);
        return total;
    }
    
}
