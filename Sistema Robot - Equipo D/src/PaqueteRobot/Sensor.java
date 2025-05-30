package PaqueteRobot;

public class Sensor implements InterfazSensor {
    
    private int id;
    private String tipo;
    private String descripcion;

    // CONSTRUCTOR
    public Sensor(int id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    @Override
    public Object captarInformacion() {
        return 0;//Logica a implementar
    }
}
