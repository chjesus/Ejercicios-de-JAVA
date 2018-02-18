package banco;

import java.util.*;
import java.io.*;

public class Cuenta {

    String nombre, count;
    double saldo, deposito, retiro;
    Scanner in = new Scanner(System.in);

    public Cuenta(String nombre, String count, double saldo) {
        this.nombre = nombre;
        this.count = count;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCount() {
        return count;
    }

    public void setCuenta(String cuenta) {
        this.count = count;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar() {

        System.out.println("***ZONA DE DEPOSITO***");
        System.out.print("Cantidad a depositar: ");
        deposito = in.nextDouble();
        this.saldo += deposito;

    }

    public void retirar() {

        boolean band;
        do {
            System.out.println("***ZONA DE RETIRO***");
            System.out.println("Cantdiad a retirar: ");
            retiro = in.nextDouble();

            if (retiro > this.saldo) {
                System.out.print("***SALDO INSUFICIENTE***");
                band = false;
            } else {
                band = true;
                this.saldo -= retiro;
            }

        } while (band == false);

    }

    public void estado() {

        System.out.println("***ESTADO DE CUENTA***");
        System.out.println("Dueño: " + nombre);
        System.out.println("Cuenta: " + count);
        System.out.println("Saldo: " + saldo + "$");

    }

}
