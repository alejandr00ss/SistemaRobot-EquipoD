package PaqueteRobot;

public class Actuador implements InterfazActuador {
    // ATRIBUTOS
    private int id;
    private String tipo;
    private String descripcion;
    
    // CONSTRUCTOR 1
    public Actuador(int id, String tipo, String descripcion){
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    // GETTERS
    public int get_id(){return id;}
    public String get_tipo(){return tipo;}
    public String get_descripcion(){return descripcion;}
    
    // SETTERS
    public void set_id(int id){this.id = id;}
    public void set_tipo(String tipo){this.tipo = tipo;}
    public void set_descripcion(String descripcion){this.descripcion = descripcion;}
    
    // OPERADORES
    @Override
    public int realizar_accion(){
        return 0;
    }
    
}
