package PaqueteRobot;
/*
NOTA: No está terminada la clase
*/

public abstract class Percepcion /*extends M_Estatico*/{
    // ATRIBUTOS
    private int n_Sensores;
    
    // CONSTRUCTOR 1
    public Percepcion(){
        this.n_Sensores = 0;
    }
    
    // GETTERS
    public int get_n_Sensores(){return n_Sensores;}
    
    // SETTERS
    public void set_n_Sensores(int n_Sensores){this.n_Sensores = n_Sensores;}
    
    // OPERACIONES
    public int procesar_datos(){
        return 0;
    }
    
    public Object captar_informacion(){
        return 0;
    }
};
