/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yeniffer
 */
public abstract class Cuenta {
    protected String cliente;
    protected String cuenta;
    protected double saldoInicial;
    protected double saldoDisponible;
    protected int maxTrans;
    protected int indTrans;
    Transaccion [] transacciones;
    
    public Cuenta (){
         cliente = " ";
         cuenta = " ";
         saldoInicial = 0.0;
         saldoDisponible = 0.0;
         maxTrans=5;
         indTrans=0;
         transacciones= new Transaccion[maxTrans];
    }

    public Cuenta (String c, String nc, double si){
         cliente = c;
         cuenta = nc;
         saldoInicial = si;
         saldoDisponible = si;
         maxTrans=5;
         indTrans=0;
         transacciones= new Transaccion[maxTrans];
    }
    
    public String getCliente(){return cliente;}
    public String getCuenta(){return cuenta;}
    public double getSaldoD(){return saldoDisponible;}
    public double getSaldoI(){return saldoInicial;}
    
    public void setSaldoD(double sd){
        saldoDisponible = sd;
    }
        
    public abstract void addTransaccion(Transaccion t);
    
    public void mostrarEstadoCuenta(){
         System.out.println("Cliente: "+cliente);
         System.out.println("Saldo Inicial: "+saldoInicial+"\n");
         System.out.println("----------TRANSACCIONES----------");
         System.out.println("Referencia              Monto");
         for(int i=0; i<transacciones.length; i++) //ó hasta indTrans
             if (transacciones[i]!=null)
                 transacciones[i].mostrar();
         System.out.println("\nSaldo Disponible: "+saldoDisponible);
         
                 
    }
}
