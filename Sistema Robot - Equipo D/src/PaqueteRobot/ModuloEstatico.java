package PaqueteRobot;

/**
 * subclase abstracta de Modulo, no agrega ningun atributo adicional ni metodo adicional
 * Superclase de ModuloEstaticoPercepcio y ModuloEstaticoActuacion
 * Este gestiona la percepcion y actuacion del robot
 */

public abstract class ModuloEstatico extends Modulo {
    @Override
    public void recibirInfoAccion(int idProblema) {
    }
    public ModuloEstatico(int id, String referencia, String descripcion, int largo, int ancho, int profundidad) {
        super(id, referencia, descripcion, largo, ancho, profundidad, "Estatico");
    }
}