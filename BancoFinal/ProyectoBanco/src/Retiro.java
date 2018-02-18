public class Retiro extends Transaccion{   
    public Retiro(){
        super();
    }
    
    public Retiro(String r, double m){
        super(r,m);
    }
    
    @Override
    public double getMonto() {
        //El monto retorno positivo porque se trata de un deposito
        return (-super.monto);
    }
    
    public void mostrar(){
        super.mostrar();
        System.out.println("\tRetiro\t\t" + this.getMonto());
    }    
}
    
    
    
    

