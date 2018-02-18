import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Banco {
    private int contReferencias;
    private int contCuentas;
    private int maxCuentas;
    private int indCuentas;
    private Cuenta [] cuentas;
    
    public Banco(){
        contReferencias=0;
        contCuentas=0;
        maxCuentas=3;
        indCuentas=0;
        cuentas= new Cuenta[maxCuentas];
    }
    public Banco(int mc){
        contReferencias=0;
        contCuentas=0;
        maxCuentas=mc;
        indCuentas=0;
        cuentas= new Cuenta[mc];
    }
    
    public int menu (){
    int opc;        
        System.out.println("\n--------------------");
        System.out.println("  Menu de Opciones  ");
        System.out.println("--------------------");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Consultar cuenta");
        System.out.println("3. Realizar transaccion");
        System.out.println("4. Salir\n");
        System.out.print("Opcion:: ");
        Scanner in = new Scanner(System.in);
        opc = in.nextInt();
        return opc;        
    }
    
    public void iniciar()throws IOException{
    int opc;
        do{
            opc = menu();
            switch(opc){
                case 1: crearCuenta();
                        break;
    
                case 2: consultarCuenta();
                        break;
                    
                case 3: realizarTransaccion();
                        break;
                    
                case 4: System.out.println("Gracias por usar nuestro sistema");
                        break;
                    
                default: System.err.println("Error en la opcion, el rango es [1-4]");
                         break;
            }
       }while(opc!=4);
    }
    
    public void crearCuenta()throws IOException{
        DataInputStream lector = new DataInputStream(System.in);
        String auxCliente;
        double auxSaldo;
        int auxTipoCuenta;
        int auxNroCuenta;
        Cuenta miCuenta = null;
        if (indCuentas<maxCuentas){
            System.out.println("Nombre del cliente: ");
            auxCliente = lector.readLine();
        
            System.out.println("Saldo inicial: ");
            auxSaldo = Double.parseDouble(lector.readLine());
            do{
                System.out.println("Tipos de cuentas: ");
                System.out.println("1. Cuenta de Ahorros");
                System.out.println("2. Cuenta Corriente");
                System.out.println("Ingrese el tipo de cuenta: ");
                auxTipoCuenta = Integer.parseInt(lector.readLine());
            }while(auxTipoCuenta<0 || auxTipoCuenta>2);              
               
            auxNroCuenta = generarCuenta();
        
            switch(auxTipoCuenta){
                case 1: cuentas[indCuentas] = new CuentaAhorro(auxCliente,String.valueOf(auxNroCuenta),auxSaldo);
                        break;
                case 2: cuentas[indCuentas] = new CuentaCorriente(auxCliente,String.valueOf(auxNroCuenta),auxSaldo);
                        break;
            }
            System.out.println("La cuenta se almaceno correctamente\n");
            cuentas[indCuentas].mostrarEstadoCuenta();
            indCuentas++;
        }
        else System.err.println("Error... No hay espacio para almacenar la cuenta");
    }
    
    public void consultarCuenta(){
        Scanner in = new Scanner(System.in);
        String auxNroCuenta;
        Cuenta miCuenta;
        System.out.println("Ingrese cuenta a consultar: ");
        auxNroCuenta = in.next();
        
        miCuenta = buscarUnaCuenta(auxNroCuenta);
        if (miCuenta!=null)
            miCuenta.mostrarEstadoCuenta();
        else System.err.println("Cuenta no existente");        
    }
    
    public Cuenta buscarUnaCuenta(String nc){
        int i=0;
        boolean encontre = false;
        while (i<indCuentas && !encontre)
            if (cuentas[i].getCuenta().compareToIgnoreCase(nc)==0)
                encontre=true;
            else i++;
        if (encontre) return cuentas[i];
        else return null;
    }
    
    public void realizarTransaccion()throws IOException{
        DataInputStream lector = new DataInputStream(System.in);
        //String auxCliente;
        //double auxSaldo;
        int auxTipoTrans;
        int auxNroReferencia;
        double auxMonto;
        String auxNroCuenta;
        Cuenta miCuenta = null;
        Transaccion miTransaccion = null;
        
        System.out.println("Ingrese el nro de cuenta: ");
        auxNroCuenta = lector.readLine();
        
        miCuenta = buscarUnaCuenta(auxNroCuenta);
        
        if (miCuenta == null)
            System.err.println("Error... Cuenta no existente");
        else {
            do{
                System.out.println("Tipos de transacciones: ");
                System.out.println("1. Deposito");
                System.out.println("2. Retiro");
                System.out.println("3. Cheque");
                System.out.println("Ingrese el tipo de transaccion: ");
                auxTipoTrans = Integer.parseInt(lector.readLine());
            }while(auxTipoTrans<0 || auxTipoTrans>3);              
               
            System.out.println("Monto de la transaccion: ");
            auxMonto = Double.parseDouble(lector.readLine());
            
            auxNroReferencia = generarReferencia();
        
            switch(auxTipoTrans)
            {   case 1: miTransaccion = new Deposito(String.valueOf(auxNroReferencia),auxMonto); 
                        break;
                case 2: miTransaccion = new Retiro(String.valueOf(auxNroReferencia),auxMonto); 
                        break;
                case 3: miTransaccion = new Cheque(String.valueOf(auxNroReferencia),auxMonto); 
                        break;    
            }            
            miCuenta.addTransaccion(miTransaccion);
        }        
    }
    
    public int generarCuenta(){
        contCuentas++;
        return contCuentas;
    }
    
    public int generarReferencia(){
        contReferencias++;
        return contReferencias;
    }
    
}
