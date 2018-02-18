
package data;

public interface Datos {
    /*Informacion de los Vuelos*/
    
    //1-Nombre
    //2-Numero de Vuelo
    //3-Ciudad Destino
  
    String[] datos_vuelos={"Conviasa;763;SC",
                           "Conviasa;125;PLM",
                           "Aeropostal;815;PLM",
                           "Conviasa;805;VAL",
                           "Aserca;725;MBO"};
    
    /*Informacion de la Personas*/
    //1-ID
    //2-Nombre
    //3-Edad
    //4-Numero De Vuelo
    //5-Codigo que indica tipo de persona (1 para Pasajero, 2 para Azafata y 3 para Piloto)
    
    /*o	En el caso de los pasajeros: el sexto corresponde a número de asiento y el séptimo al valor del pasaje
      o	En el caso de las azafatas: el sexto corresponde a estatura y el séptimo a la cantidad de idiomas
      o	En el caso de los pilotos: el sexto corresponde a horas de vuelo */
     
    String[] datos_persona={"1;Jose Gonzalez;23;763;1;23A;550",
                            "2;María Ramírez;19;125;2;1.65;3",
                            "3;José Montoya;29;725;3;1350",
                            "4;Gerardo Jaimes;25;805;3;2345",
                            "5;Ana Pérez;36;815;2;1.72;4",                         
                            "6;Emiro Martinez;33;815;1;5A;700",
                            "7;Anabella Martinez;18;763;1;14C;320",                       
                            "8;Mercedes Delgado;58;763;1;18D;440",
                            "9;Diego Herrera;25;763;3;2445",                        
                            "10;Cluadia Fernandez;47;763;1;6E;350"};
    
}
