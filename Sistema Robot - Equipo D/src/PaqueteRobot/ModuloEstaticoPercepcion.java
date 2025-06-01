package PaqueteRobot;

/**
 * Clase abstracta que representa un módulo estático de percepción
 * subclase de ModuloEstatico
 * tiene un atributo numeroSensores
 * tiene dos metodos abstractos procesarDatos y captarInformacion
 * superclase de SensorProximidad y Camara
 */
public abstract class ModuloEstaticoPercepcion extends ModuloEstatico {
    // ATRIBUTOS
    private int numeroSensores;
    
    // CONSTRUCTOR
    public ModuloEstaticoPercepcion(int id, String referencia, String descripcion, 
                                   int largo, int ancho, int profundidad) {
        super(id, referencia, descripcion, largo, ancho, profundidad);
    }
    
    // GETTERS
    public int getNumeroSensores() { return numeroSensores; }
    
    // SETTERS
    public void setNumeroSensores(int numeroSensores) { this.numeroSensores = numeroSensores; }
    
    // OPERACIONES ABSTRACTAS
    public abstract int procesarDatos(Object sensor);
    
    public abstract Object captarInformacion(char rowChar, char colChar, char[][] matriz);
}