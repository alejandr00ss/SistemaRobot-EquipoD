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

    public void interpretarMensaje(String[] mensaje) {
        System.out.println("[SistemaControl Módulo " + idModulo + "] Mensaje recibido: " + mensaje[0]);
    }

    @Override
    public boolean enviarRespuestaAccion() {
        System.out.println("[SistemaControl Módulo " + idModulo + "] Respuesta de acción enviada.");
        return true;
    }

    @Override
    public List<String> gestionarSolucion(int idProblema) {
        System.out.println("[SistemaControl Módulo " + idModulo + "] Gestionando solución para ID de problema: " + idProblema);
        List<String> soluciones = new ArrayList<>();
        
        if (idProblema == 56754) {
            soluciones.add("Avanzar");
            soluciones.add(Integer.toString(idModulo));
        }
        return soluciones;
    }
}