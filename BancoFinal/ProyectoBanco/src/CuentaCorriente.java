public class CuentaCorriente extends Cuenta{
    public CuentaCorriente(String c, String nc, double si){
        super(c, nc, si);           
    }
    
    public CuentaCorriente(){
        super();
    }
    
    public void addTransaccion(Transaccion t) {
        if (t instanceof Deposito || t instanceof Cheque){
            double saldoAux = super.getSaldoD()+ t.getMonto();
            if (saldoAux<0)
                System.err.println("Error! El saldo disponible es insuficiente");
            else{
                super.setSaldoD(saldoAux);
                if (indTrans<maxTrans){
                     transacciones[indTrans]= t;
                     indTrans++;
                     System.out.println("Transaccion realizada con exito");
                }
                else System.err.println("No hay espacio para almacenar la transaccion");
            }             
        }
        else System.err.println("Esta transacción no es permitida en una cuenta corriente");
    }
    
    public void mostrarEstadoCuenta(){
        System.out.println("Cuenta Corriente Nro: "+super.getCuenta());
        super.mostrarEstadoCuenta();
    }   
    
}
