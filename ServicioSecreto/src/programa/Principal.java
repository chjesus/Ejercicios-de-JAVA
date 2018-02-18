
package programa;

import confidencial.datos_confidenciales;
import confidencial.numeros;

public class Principal implements numeros{
    
    public Principal(){
        
    }
    public void cargarDatos(){
        categori_agente[] vec = new categori_agente[numeros.cant_agentes];
        
        datos_confidenciales datos = new datos_confidenciales();
        
        String agent,categ;
        String aux[] = new String[4];
        String aux2[] = new String[3];
        
        /*Datos de Agentes*/
        String nombre[] = new String[2];
        String apellido[] = new String[2];
        String nroSeguro[] = new String[2];
        String estado[] = new String[2];
        
        /*Datos de Categoria*/
        String NroSeguro[] = new String[2];
        String palabraOtorg[] = new String[2];
        String cedula[] = new String[2];

        for (int i = 0; i < numeros.cant_agentes; i++) {
            agent=datos.devolver_agentes(i);
            aux=agent.split(" ");
            nombre[i]=aux[0];
            apellido[i]=aux[1];
            nroSeguro[i]=aux[2];
            estado[i]=aux[3];
                for (int j = 0; j < numeros.cant_agentes; j++) {
                    categ=datos.devolver_categoria(j);
                    aux2=categ.split(" ");
                    NroSeguro[j]=aux2[0];
                    palabraOtorg[j]=aux2[1];
                    cedula[j]=aux2[2];
                    if(nroSeguro[i].equals(NroSeguro[j])){
                        //System.out.println("Funciona!!!!");
                        vec[j] = new categori_agente(Integer.parseInt(nroSeguro[i]),estado[i],palabraOtorg[j],nombre[i],apellido[i],cedula[j]);
                    }
                }
            //System.out.println("Nombres: "+nombre[i]);
        }
        imprimir_datos_categorias(vec);
        
    }
    @Override
    public void imprimir_datos_categorias(categori_agente[] vec) {
        int categoria=0;
        System.out.println("---Datos de los agentes---");
        System.out.println("Nombre:\t Apellido: \t Cedula: \t Palabra Otorgada: \tCategoria: \tPromedio de Cedula: \tPago: ");
        for (int i = 0; i < vec.length; i++) {
            if(vec[i].palindromo_regular()==true && vec[i].cadena_espejo()==false && vec[i].palindromo_espejo()==false){
                categoria=1;
            }else if(vec[i].palindromo_regular()==true && vec[i].cadena_espejo()==true && vec[i].palindromo_espejo()==false){
                categoria=2;
            }else if(vec[i].palindromo_regular()==true && vec[i].cadena_espejo()==true && vec[i].palindromo_espejo()==true){
                categoria=3;
            }else{
                categoria=4;
            }
            System.out.println(vec[i].getNombre()+" \t "+vec[i].getApellido()+" \t "+vec[i].getCedula()+" \t "+vec[i].getPalabra_otorgada()+" \t\t"+categoria+" \t\t"+vec[i].suma_cedula()+" \t\t\t"+vec[i].pago_por_categoria());
        }
    }
    
    public static void main(String[] args) {
        Principal in = new Principal();
        in.cargarDatos();
    }
}
