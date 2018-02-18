public abstract class Transaccion {
    protected String referencia;
    protected double monto;
    public Transaccion (String r, double m){
        referencia = r;
        monto = m ;
    }

    public Transaccion (){
        referencia = " ";
        monto = 0.0 ;
    }
    
    public abstract double getMonto();
    
    public void mostrar(){
        System.out.print(referencia);
    }
    
}
