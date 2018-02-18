
package palindromo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromo {
    String palabra;
    int contar;
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    public void ValidarPalindromo() throws IOException{
        int val;
        char letra = 0;
        char letraAux = 0;
        System.out.print("Ingrese la palabra que desea saber si es palindromo: ");
        palabra=leer.readLine();
        contar=palabra.length();
            if((contar-1)%2==0){
                val=contar/2;
                for (int i = 0; i < val; i++) {
                    letra=palabra.charAt(i);
                    letraAux=palabra.charAt(val+i+1);
                    if(letra==letraAux){
                        System.out.println("La palabra: ["+palabra+"] es Palindromo");
                    }
                }
            }else{
                System.out.println("No es Palindromo.");
            }
    }
    public static void main(String[] args) throws IOException {
       Palindromo pal = new Palindromo();
       pal.ValidarPalindromo();
    }
}
