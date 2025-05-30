package PaqueteRobot;

/**
 * Clase abstracta que representa un módulo estático de actuación
 * subclase de ModuloEstatico
 * tiene un atributo numeroActuadores
 * tiene un metodo abstracto realizarAccion
 * superclase de Altavoz
 */
public abstract class ModuloEstaticoActuacion extends ModuloEstatico {
    
    private int numeroActuadores;
    
    // CONSTRUCTOR
    public ModuloEstaticoActuacion(int id, String referencia, String descripcion, 
                                   int largo, int ancho, int profundidad) {
        super(id, referencia, descripcion, largo, ancho, profundidad);
    }
    
    // GETTERS
    public int getNumeroActuadores() { return numeroActuadores; }
    
    // SETTERS
    public void setNumeroActuadores(int numeroActuadores) { this.numeroActuadores = numeroActuadores; }

    public abstract int realizarAccion();
}