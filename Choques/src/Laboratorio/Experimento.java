
package Laboratorio;

public class Experimento {
    Cuerpo cuerpo1;
    Cuerpo cuerpo2;

    public Experimento(Cuerpo cuerpo1, Cuerpo cuerpo2) {
        this.cuerpo1 = cuerpo1;
        this.cuerpo2 = cuerpo2;
    }
    
    public double getVelocidadFinal(){
        return (cuerpo1.calcularsCantMov()+cuerpo2.calcularsCantMov())/(cuerpo1.getMasa()+cuerpo2.getMasa());
    }
    public double getEnergiaMecFinal(){
        return (double)((cuerpo1.getMasa()+cuerpo2.getMasa())*(getVelocidadFinal()*getVelocidadFinal()))/2;
    }
    public double getEnergiaMecPerdida(){
        return getEnergiaMecFinal()-(cuerpo1.CalcularEnergiaMec()+cuerpo2.CalcularEnergiaMec());
    }
    public void imprimirExperimento(int a){
        System.out.println("Experimento: "+a);
        System.out.println("Cuerpo 1: "+cuerpo1.toString());
        System.out.println("Cuerpo 2: "+cuerpo2.toString());
        System.out.println("Velocidad Final: "+getVelocidadFinal()+" m/s");
        System.out.println("Energia Mecanica Perdida: "+getEnergiaMecPerdida()+" J");

    }
}
