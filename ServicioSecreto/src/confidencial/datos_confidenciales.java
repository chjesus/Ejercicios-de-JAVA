
package confidencial;

public class datos_confidenciales {

    public datos_confidenciales() {
    }
    
    private String[] datos_agentes={"Juan Colina 1012 estadoA",
                                    "Carlos Colmenares 2145 estadoC"
                                    };
    private String[] categorias={"2145 ATOYOTA 15263558",
                                 "1012 2A3MEAS 1258522"
                                    };
    
    public String devolver_agentes(int numero){
       
       return datos_agentes[numero];
    }
    
    public String devolver_categoria(int numero){
        
        return categorias[numero];
    }
}
