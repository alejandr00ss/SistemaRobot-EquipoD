package PaqueteRobot;

import java.util.List;
import java.util.ArrayList;

/**
 * Sistema de control que implementa la interfaz InterfazSistemaControl.
 * tiene una relacion uno a uno con modulo, le informa la accion
 * tiene una relacion uno a uno con sistema de comunicacion, le pasa el mensaje
 * es una composicion con modulo
 */
public class SistemaControl implements InterfazSistemaControl {

    private int idModulo; //Relacion uno a uno con modulo
    
    // CONSTRUCTOR
    public SistemaControl(int idModulo) {
        this.idModulo = idModulo;
    }

    // GETTER
    public int getIdModulo() {
        return idModulo;
    }

    // SETTER
    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    // MÉTODOS
    public void interpretarMensaje(String mensaje) {
        // Lógica para interpretar el mensaje
        if (mensaje == "Objeto") {
            this.enviarRespuestaAccion();
        } else if (mensaje == "apagar") {
            this.enviarRespuestaAccion();
        }
    }//Algo así, más adelante se implementa
    
    // IMPLEMENTACIÓN DE INTERFAZ operaciones propagadas por modulo
    @Override
    public boolean enviarRespuestaAccion() {
        return true;
    }

    @Override
    public List<String> gestionarSolucion(int id) {
        List<String> soluciones = new ArrayList<>();
        // Aquí puedes agregar las soluciones que necesites
        soluciones.add("Solución 1 para ID " + id);
        soluciones.add("Solución 2 para ID " + id);
        return soluciones;
    }
}