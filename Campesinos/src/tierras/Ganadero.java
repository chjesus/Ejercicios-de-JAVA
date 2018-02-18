
package tierras;

public class Ganadero extends Campesino{
    private int cantGanado;
    private double precioCabezaGanado;

    public Ganadero(String nombre, String cedula, int edad, String situacionSocial, int cantGanado, double precioCabezaGanado) {
        super(nombre, cedula, edad, situacionSocial);
        this.cantGanado = cantGanado;
        this.precioCabezaGanado = precioCabezaGanado;
    }

    public int getCantGanado() {
        return cantGanado;
    }

    public double getPrecioCabezaGanado() {
        return precioCabezaGanado;
    }
    
    public double calcular_ganancia(){
        double precioTotal;
        precioTotal = cantGanado*precioCabezaGanado;
        return precioTotal;
    }
    @Override
    public void determinar_situacion_social() {
       situacionSocial="Elevada";
       System.out.println(""+situacionSocial);
    }
}
