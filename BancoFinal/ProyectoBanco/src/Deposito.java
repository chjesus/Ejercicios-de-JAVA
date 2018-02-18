public class Deposito extends Transaccion {
    
    
    public Deposito(){
        super();
    }
    
    public Deposito(String r, double m){
        super(r,m);
    }
    
    @Override
    public double getMonto() {
        //El monto retorno positivo porque se trata de un deposito
        return super.monto;
    }
    
    public void mostrar(){
        super.mostrar();
        System.out.println("\tDeposito\t" + this.getMonto());
    }    
}
