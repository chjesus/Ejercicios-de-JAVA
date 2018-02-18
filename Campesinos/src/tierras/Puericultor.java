
package tierras;

public class Puericultor extends Campesino{
    private String zonaVive;

    public Puericultor(String nombre, String cedula, int edad, String situacionSocial, String zonaVive) {
        super(nombre, cedula, edad, situacionSocial);
        this.zonaVive = zonaVive;
    }

    public String getZonaVive() {
        return zonaVive;
    }
    
    @Override
    public void determinar_situacion_social() {
        if(getEdad()>40 && zonaVive.equals("Occidente")){
            situacionSocial="Elevada";
        }
        if((getEdad()>=25 && getEdad()<=40) && zonaVive.equals("Oriente")){
            situacionSocial="Normal";
        }
        System.out.println(""+situacionSocial);
    }  
}
