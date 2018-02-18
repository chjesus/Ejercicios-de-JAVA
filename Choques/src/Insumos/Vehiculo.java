
package Insumos;

public abstract class Vehiculo {
    String marca;
    String modelo;
    int id;

    public Vehiculo(String marca, String modelo, int id) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getId() {
        return id;
    }
    
    public abstract double masaTotal();
}
