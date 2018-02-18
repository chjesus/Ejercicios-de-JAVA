//Orden para codificar las clases
//Cuenta - Banco
//Transaccion - Deposito - Retiro
//CuentaAhorro - CuentaCorriente


import java.io.IOException;

public class Principal {

    public static void main(String[] args)throws IOException {
        Banco sistema = new Banco();
        sistema.iniciar();
    }
    
}
