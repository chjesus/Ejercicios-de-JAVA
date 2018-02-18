
package programa;

import confidencial.agentes;

public class categori_agente extends agentes{
    private int seguro_social;
    private String estado;
    private String palabra_otorgada;
    
    public categori_agente() {
        
    }
    public categori_agente(int seguro_social, String estado, String palabra_otorgada, String nombre, String apellido, String cedula) {
        super(nombre, apellido, cedula);
        this.seguro_social = seguro_social;
        this.estado = estado;
        this.palabra_otorgada = palabra_otorgada;
    }
    public int suma_cedula(){
        int ced=0,sumar=0,cont=0;
        int prom=0;
        char num;
        for (int i = 0; i < this.getCedula().length(); i++) {
            num=getCedula().charAt(i);
            ced=Integer.parseInt("" + num);
            sumar+=ced;
            cont++;
        }
        prom=sumar/cont;
        return prom;
    }
    public int suma_cedula(int indice){
        int ced=indice;
        
        for (int i = 0; i < this.getCedula().length(); i++) {
            if(i==indice){
                ced=Integer.parseInt(""+this.getCedula().charAt(i));
                ced=ced;
                break;
            }
        }
        return ced;
    }
    public int getSeguro_social() {
        return seguro_social;
    }

    public void setSeguro_social(int seguro_social) {
        this.seguro_social = seguro_social;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPalabra_otorgada() {
        return palabra_otorgada;
    }

    public void setPalabra_otorgada(String palabra_otorgada) {
        this.palabra_otorgada = palabra_otorgada;
    }

    @Override
    public boolean palindromo_regular() {
        int contar=0,val=0,cont=0;
        char letra,letraAux;
        contar=palabra_otorgada.length();
            if((contar-1)%2==0){
                val=contar/2;
                for (int i = 0; i < val; i++) {
                    letra=palabra_otorgada.charAt(i);
                    letraAux=palabra_otorgada.charAt(val+i+1);
                    if(letra==letraAux){
                        cont++;
                    }
                }
            }
            if(cont>0){
                return true;
            }else{
                return false;
            }
    }

    @Override
    public boolean cadena_espejo() {
        int cont=0;
        String palReInvertido="";
        String palRe="";
        String Caracter="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        String Reverso="A   3  HIL JM O   2TUVWXY51SE Z  8 ";
            for (int i = 0; i < palabra_otorgada.length(); i++) {
                for (int j = 0; j < Reverso.length(); j++) {
                    if(palabra_otorgada.charAt(i)==Caracter.charAt(j)){
                        if(Reverso.charAt(j)!=' '){
                            palRe+=Reverso.charAt(j);
                        }     
                    }
                }
            }
            
            for (int i = palRe.length()-1; i>=0; i--) {
                palReInvertido+=palRe.charAt(i);
            }
            cont=0;
            for (int i = 0; i < palabra_otorgada.length(); i++) {
                if(palabra_otorgada.equals(palReInvertido)){
                    cont++;
                }
            }
            if(cont>0){
                return true;
            }else {
                return false;
            }
    }
    
    @Override
    public boolean palindromo_espejo() {
        if(palindromo_regular()==true && cadena_espejo()==true){
            return true;
        }else{
            return false;
        }
    }
    
    public int pago_por_categoria(){
        int sueldo=100000;
        if(this.palindromo_regular()==true && this.cadena_espejo()==false && this.palindromo_espejo()==false){
            return sueldo;
        }
        if(this.palindromo_regular()==true && this.cadena_espejo()==true && this.palindromo_espejo()==false){
            sueldo+=sueldo*0.10;
            return sueldo;
        }
        if(this.palindromo_regular()==true && this.cadena_espejo()==true && this.palindromo_espejo()==true){
            sueldo+=sueldo*0.15;
            return sueldo;
        }else {
            return sueldo=15000;
        }
    }
}
