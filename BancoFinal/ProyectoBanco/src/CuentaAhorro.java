public class CuentaAhorro extends Cuenta{
    public CuentaAhorro(String c, String nc, double si){
        super(c, nc, si);           
    }
    
    public CuentaAhorro(){
        super();
    }
    
    public void addTransaccion(Transaccion t) {
        if (t instanceof Deposito || t instanceof Retiro){
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
        else System.err.println("Esta transacción no es permitida en una cuenta de ahorro");
    }
    
    public void mostrarEstadoCuenta(){
        System.out.println("Cuenta Ahorro Nro: "+super.getCuenta());
        super.mostrarEstadoCuenta();
    }   
    
}

