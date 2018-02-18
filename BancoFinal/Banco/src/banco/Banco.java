package banco;

import java.util.*;
import java.io.*;

public class Banco {

    //Scanner in = new Scanner(System.in);
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Cuenta> cuentas = new ArrayList<>();
    String entidad;
    int op;

    public Banco(String entidad) {
        this.entidad = entidad;
    }

    public void menu() throws IOException {

        System.out.println("***Bienvenido al banco " + entidad + "***");
        System.out.println("1. Abrir Cuenta");
        System.out.println("2. Consultar estado de cuenta");
        System.out.println("3. Realizar deposito");
        System.out.println("4. Realizar retiro");
        System.out.println("5. Salir");
        System.out.print("    Su opcion: ");
        op = Integer.parseInt(leer.readLine());
        switch (op) {

            case 1:
                crear();
                menu();
            case 2:
                consulta();
                menu();
            case 3:
                reaDeposito();
                menu();
            case 4:
                reaRetiro();
                menu();
            case 5:
                break;

        }

    }

    public void crear() throws IOException {

        String nom, cue;
        double sal;

        System.out.print("Nombre: ");
        nom = leer.readLine();
        System.out.print("Cuenta: ");
        cue = leer.readLine();
        System.out.print("Saldo inicial: ");
        sal = Double.parseDouble(leer.readLine());
        Cuenta aux = new Cuenta(nom, cue, sal);
        cuentas.add(aux);

    }

    public void consulta() throws IOException {

        String op;

        System.out.println("***SISTEMA DE CONSULTA***");
        System.out.print("Ingrese su numero de cuenta: ");
        op = leer.readLine();
        for (int i = 0; i < cuentas.size(); i++) {
            if (op.equalsIgnoreCase(cuentas.get(i).getCount())) {
                
                cuentas.get(i).estado();
                
            }
        }

    }

    public void reaDeposito() throws IOException {

        String op;
        double dep, ret;

        System.out.println("***SISTEMA DE DEPOSITO***");
        System.out.print("Ingrese su numero de cuenta: ");
        op = leer.readLine();
        for (int i = 0; i < cuentas.size(); i++) {
            if (op.equalsIgnoreCase(cuentas.get(i).getCount())) {
                
               cuentas.get(i).depositar();
                
            }
        }

    }

    public void reaRetiro() throws IOException {

        String op;
        double ret;

        System.out.println("***SISTEMA DE RETIRO***");
        System.out.print("Ingrese su numero de cuenta: ");
        op = leer.readLine();
        for (int i = 0; i < cuentas.size(); i++) {
            if (op.equalsIgnoreCase(cuentas.get(i).getCount())) {
                
                cuentas.get(i).retirar();
                
            }
        }

    }

}
