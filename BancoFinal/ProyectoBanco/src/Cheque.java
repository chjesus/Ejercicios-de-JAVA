public class Cheque extends Transaccion{
    public Cheque(){
        super();
    }
    
    public Cheque(String r, double m){
        super(r,m);
    }
    
    @Override
    public double getMonto() {
        //El monto retorno positivo porque se trata de un deposito
        return (-super.monto);
    }
    
    public void mostrar(){
        super.mostrar();
        System.out.println("\tCheque\t" + this.getMonto());
    }    
}