
package agencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal implements DatosGenerales{
    
     private BufferedReader leer=null;
     private FileReader archivo=null;
     private  Evento misEventos[];
     private int contar,cant_juegos_totales=0,cant_pasapalos_dulces=0,cant_tortas=0,cant_pasapalos_salados=0;
     private String codigos[];
    public Principal() {
        contar=0;
        misEventos=new Evento[5];
        codigos=new String [5];
    }

    public int getCant_juegos_totales() {
        return cant_juegos_totales;
    }

    public int getCant_pasapalos_dulces() {
        return cant_pasapalos_dulces;
    }

    public int getCant_tortas() {
        return cant_tortas;
    }

    public int getCant_pasapalos_salados() {
        return cant_pasapalos_salados;
    }
    
    public void cargar_datos(){
        
         String Torta="",Pasapalos_dulces="",Pasapalos_salados="",Decoracion="";
         String  pre_torta="",pre_dulces="",pre_salados="",decoracion="";
         String vec[]=DatosGenerales.datos_alimentos;
         
         for (int i = 0; i < vec.length; i++) {
             String aux[]=vec[i].split("-");
             
               for (int j = 0; j < aux.length; j++) {
                 
                   if(i==0){
                       
                       if (j==0) {
                           Torta=aux[j];
                       }
                       if (j==1) {
                           pre_torta=aux[j];
                       }
                       
                   }
                   if(i==1){
                       
                       if (j==0) {
                           Pasapalos_dulces=aux[j];
                       }
                       if (j==1) {
                            pre_dulces=aux[j];
                       }
                       
                   }
                   if(i==2){
                       
                       if (j==0) {
                                Pasapalos_salados=aux[j];
                       }
                       if (j==1) {
                            pre_salados=aux[j];
                       }
                       
                   }
                   if(i==3){
                       
                       if (j==0) {
                                  Decoracion=aux[j];
                       }
                       if (j==1) {
                           decoracion=aux[j];
                       }
                       
                   }
                   
                   
                   
                   
               }
             
         }
         //------------------------- fin de datos de eventos ---------------------------------
         String detectar="";
         String tipo_de_evento="",codigo="",representante="",fecha="",dirrecion="",confirmacion="",edo_torta="",cant_tortas="",edo_dulces="",cant_dulces="",
                 edo_salados="",cant_salados="",edo_decoracion="",cant_decoracion="";
        String    mot_de_fiesta="" ;int num_de_anim=0,num_juegos=0;int num_canciones=0;
         try {
             archivo=new FileReader(new File ("src/agencia/Eventos.in.txt"));
             leer=new   BufferedReader(archivo);
         } catch (FileNotFoundException ex) {
              System.out.println("archivo no encontrado ");
         }
         while(detectar!=null){
             
             try {
                 detectar=leer.readLine();
             } catch (IOException ex) {
                 System.out.println("no consiui el archivo ");
             }
             if(detectar!=null){
                        String Aux[]=detectar.split("\\*");
                   for (int i = 0; i < Aux.length; i++) {

                        if(i==0){ codigo=Aux[i]; this.codigos[contar]=Aux[i];}
                         if(i>0){
                             
                            if(i==1){tipo_de_evento=Aux[i];}
                            if(i==2){representante=Aux[i];}
                            if(i==3){fecha=Aux[i];}
                            if(i==4){dirrecion=Aux[i];}
                            if(i==5){confirmacion=Aux[i];}
                            if(i==6){edo_torta=Aux[i];}
                            if(i==7){cant_tortas=Aux[i];}
                            if(i==8){edo_dulces=Aux[i];}
                            if(i==9){cant_dulces=Aux[i];}
                            if(i==10){edo_salados=Aux[i];}
                            if(i==11){cant_salados=Aux[i];}
                            if(i==12){edo_decoracion=Aux[i];}
                            if(i==13){cant_decoracion=Aux[i];}
                         }
                   }
                 if(tipo_de_evento.equalsIgnoreCase("M")){
                       String revisar[]=cant_decoracion.split("%");
                        for (int k = 0; k <revisar.length; k++) {
                            
                         if(k==0){ cant_decoracion=revisar[k]; }
                         if(k==1){ num_canciones=Integer.parseInt(revisar[k]);}
                           
                       }
                     misEventos[contar]=new Matrimonios(dirrecion,num_canciones,representante,fecha,dirrecion,confirmacion,"0"); 
                     ((Matrimonios)misEventos[contar]).calcular_pago_evento();
                      if(confirmacion.equalsIgnoreCase("true")){
                          this.cant_tortas+=Integer.parseInt(cant_tortas);
                          this.cant_pasapalos_dulces+=Integer.parseInt(cant_dulces);
                          this.cant_pasapalos_salados+=Integer.parseInt(cant_salados);
                      }
                      
                     for (int i = 0; i < misEventos[contar].rubrosBasicos.length; i++) {
                           
                        if(i==0)misEventos[contar].rubrosBasicos[i]=new comboBasico(Torta,edo_torta,cant_tortas,pre_torta);
                        if(i==1)misEventos[contar].rubrosBasicos[i]=new comboBasico(Pasapalos_dulces,edo_dulces,cant_dulces,pre_dulces);
                        if(i==2)misEventos[contar].rubrosBasicos[i]=new comboBasico(Pasapalos_salados,edo_salados,cant_salados,pre_salados);
                        if(i==3)misEventos[contar].rubrosBasicos[i]=new comboBasico(Decoracion,edo_decoracion,cant_decoracion,decoracion);
                        
                    }
                     contar++;
                 }
                 if(tipo_de_evento.equalsIgnoreCase("B")){
                     
                           String revisar[]=cant_decoracion.split("%");
                        for (int k = 0; k <revisar.length; k++) {
                            
                         if(k==0){ cant_decoracion=revisar[k]; }
                         if(k==1){ num_juegos=Integer.parseInt(revisar[k]);
                           this.cant_juegos_totales+=num_juegos;
                                 }
                            
                       }
                      misEventos[contar]=new BabyShower(num_juegos,representante,fecha,dirrecion,confirmacion,"0"); 
                      ((BabyShower)misEventos[contar]).calcular_pago_evento();
                       if(confirmacion.equalsIgnoreCase("true")){
                          this.cant_tortas+=Integer.parseInt(cant_tortas);
                          this.cant_pasapalos_dulces+=Integer.parseInt(cant_dulces);
                          this.cant_pasapalos_salados+=Integer.parseInt(cant_salados);
                      }
                        for (int i = 0; i < misEventos[contar].rubrosBasicos.length; i++) {
                           
                        if(i==0)misEventos[contar].rubrosBasicos[i]=new comboBasico(Torta,edo_torta,cant_tortas,pre_torta);
                        if(i==1)misEventos[contar].rubrosBasicos[i]=new comboBasico(Pasapalos_dulces,edo_dulces,cant_dulces,pre_dulces);
                        if(i==2)misEventos[contar].rubrosBasicos[i]=new comboBasico(Pasapalos_salados,edo_salados,cant_salados,pre_salados);
                        if(i==3)misEventos[contar].rubrosBasicos[i]=new comboBasico(Decoracion,edo_decoracion,cant_decoracion,decoracion);
                        
                    }
                     contar++;
                    
                 }
                 if(tipo_de_evento.equalsIgnoreCase("F")){
                     
                           String revisar[]=cant_decoracion.split("%");
                        for (int k = 0; k <revisar.length; k++) {
                            
                         if(k==0){ cant_decoracion=revisar[k]; }
                         if(k==1){ mot_de_fiesta=revisar[k];}
                         if(k==2){ num_de_anim=Integer.parseInt(revisar[k]);}
                            
                       }
                    misEventos[contar]=new Fiestas_infantiles(num_de_anim,mot_de_fiesta,representante,fecha,dirrecion,confirmacion,"0");     
                       ((Fiestas_infantiles)misEventos[contar]).calcular_pago_evento();
                        if(confirmacion.equalsIgnoreCase("true")){
                          this.cant_tortas+=Integer.parseInt(cant_tortas);
                          this.cant_pasapalos_dulces+=Integer.parseInt(cant_dulces);
                          this.cant_pasapalos_salados+=Integer.parseInt(cant_salados);
                      }
                       for (int i = 0; i < misEventos[contar].rubrosBasicos.length; i++) {
                           
                        if(i==0)misEventos[contar].rubrosBasicos[i]=new comboBasico(Torta,edo_torta,cant_tortas,pre_torta);
                        if(i==1)misEventos[contar].rubrosBasicos[i]=new comboBasico(Pasapalos_dulces,edo_dulces,cant_dulces,pre_dulces);
                        if(i==2)misEventos[contar].rubrosBasicos[i]=new comboBasico(Pasapalos_salados,edo_salados,cant_salados,pre_salados);
                        if(i==3)misEventos[contar].rubrosBasicos[i]=new comboBasico(Decoracion,edo_decoracion,cant_decoracion,decoracion);
                        
                    }
                   
                    
                 contar++;
                 }
                   
             }
            
         }
         
         
    }
      public static void   main(String [] args ){
          
          Principal archivo=new Principal();
          archivo.cargar_datos();
          Scanner leer =new Scanner(System.in);
          int cambio=0,op;
          String evento;
          PrintWriter  escribir=null;
          FileWriter ARCHIVO=null;
          System.err.println("EL CODIGO TIENE MUCHOS ERRORES. PENDIENTE PARA ARREGLAR DETALLES!.");

          System.out.println("!OJO SOLO SE EJECUTA UNA VZ DEBIDO A LA ESCRITURA DE LINEAS DATOS ADICCIONALES QUE SE LE AGREGA \n"
                  + " al acrchivo despues de salir GRACIAS !! "+" porq si lo vuelves a jecutar alteraras el archivo y explotara ");
          do{
              System.out.println("1. Confirmar evento.");
            System.out.println("2. Indicar cantidad total de juegos y monto total");
            System.out.println("3. Mostrar una lista consolidada de todos los pasapalos y tortas");
            System.out.println("4. listado");
            System.out.println("5. Salir.");
            op=leer.nextInt();
               switch (op) {
                  case 1:
                       System.out.println(" ingresa el evento que deseas buscar ");
                       evento=leer.next();
                       
                         for (int i = 0; i < archivo.misEventos.length; i++) {
                             
                             if(evento.equalsIgnoreCase(archivo.codigos[i])){
                                  
                                 if(archivo.misEventos[i].confirmacion.equalsIgnoreCase("true")){
                                     System.out.println("evento confirmado anteriormente”.");
                                 }
                                 if(archivo.misEventos[i].confirmacion.equalsIgnoreCase("false")){
                                     archivo.misEventos[i].confirmacion="true";
                                    System.out.println("evento confirmado");
                                 }
                                 break;
                             }
                             else{
                                     System.out.println("evento no registrado");break;
                                 }
                        }
                      break;
                  case 2:
                       
                      
                         int aux1= Integer.parseInt( (archivo.misEventos[2].getMonto_pagar()));
                         int aux2= Integer.parseInt( (archivo.misEventos[4].getMonto_pagar()));
                         System.out.println("Cant total de juegos : "+archivo.getCant_juegos_totales()+"  Monto total a pagar : "+(aux1+aux2));
                  
                      
                      break;
                  case 3:
                         System.out.println(" \n Lista de tortas y pasapalos encargados");
                         System.out.println("Unidades Descripcion");
                         System.out.println(""+archivo.getCant_tortas()+"      Tortas ");
                         System.out.println(""+archivo.getCant_pasapalos_salados()+"    Pasapalos salados ");
                         System.out.println(""+archivo.getCant_pasapalos_dulces()+"     Pasapalos dulcess \n");
                                               
                      break;
                  case 4:
                       System.out.println("Representante   CódigoEvento   Fecha    Estado");
                         for (int i = 0; i < 5; i++) {
                             
                      System.out.println("      "+archivo.misEventos[i].getRepresentante()+"  "+archivo.codigos[i]+
                              " "+archivo.misEventos[i].fecha_evento+" "+archivo.misEventos[i].confirmacion);
                          
                      }
                         System.out.println("");
                      break;
                  case 5:
                      
            
                  try {
                      // aqui añado las lineas de datos adiccionales 
                      ARCHIVO=new FileWriter("src/agencia/Eventos.in.txt"); 
                      escribir=new PrintWriter(ARCHIVO);
                       escribir.println("123*F*Jose Perez*10-Ago-2012*La Concordia*false*true*1*true*100*true*100*false*0%Doky%2");
                       escribir.println("789*B*Gloria Castro*2-Jun-2012*Paramillo*true*true*2*false*0*true*300*false*0%7");
                       escribir.println("456*F*Luisa Ramos*25-Jul-2012*Barrio Sucre*false*true*2*true*250*true*300*true*1%Ben 10%3");
                       escribir.println("258*M*Luis Roa*17-Jun-2012*Sta Teresa*false*true*1*false*0*true*800*true*1%20");
                       escribir.println("157*F*Mia Vargas*22-Ago-2012* La Concordia*true*false*0*true*100*true*100*false*0%Peppa%1");
                       escribir.println("Representante   CódigoEvento   Fecha    Estado");
                         for (int i = 0; i < 5; i++) {
                             
                      escribir.println("      "+archivo.misEventos[i].getRepresentante()+"  "+archivo.codigos[i]+
                              " "+archivo.misEventos[i].fecha_evento+" "+archivo.misEventos[i].confirmacion);
                          
                      }
                      ARCHIVO.close();
                  } catch (IOException ex) {
                      System.out.println("archivo no encontrado ");
                  }
              
                    
                      
                      
                         cambio=1;
                      break;
                 
              }
          }while(cambio==0);
            
         
          
      }
}
