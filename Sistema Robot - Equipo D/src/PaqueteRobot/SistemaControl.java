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
        List<String> soluciones = new ArrayList<>();
        System.out.println("[SistemaControl Módulo " + idModulo + "] Interpretando mensaje: " + mensaje);
        if (mensaje.equals("MASCOTA")) {
            System.out.println("Alerta: Mascota detectada. Tomando precauciones.");
            // Lógica adicional: notificar al robot, cambiar ruta, etc.
        } else if (mensaje.equals("PERSONA")) {
            System.out.println("Información: Persona detectada cerca.");
            // Lógica adicional
        } else if (mensaje.equals("OBJETO")) {
            System.out.println("Alerta: Obstáculo (Objeto) detectado.");
            // Lógica adicional: iniciar maniobra evasiva, solicitar solución.
            List<String> posiblesSoluciones = gestionarSolucion(1); // Suponiendo que 1 es el ID para "OBJETO"
            System.out.println("Posibles soluciones: " + posiblesSoluciones);
        } else if (mensaje.equals("LIBRE")) {
            System.out.println("Estado: Camino libre.");

        } else if (mensaje.equals("Avanzar")) {
            System.out.println("Comando: Mover adelante.");
            // Lógica para avanzar
            soluciones = gestionarSolucion(56754);
            System.out.println("Accion a realizar: " + soluciones.get(0) + " al modulo: " + soluciones.get(1));
            idModulo = Integer.parseInt(soluciones.get(1));
            // Enviar respuesta de acción al módulo
            enviarRespuestaAccion();

        } else if (mensaje.equals("DERECHA")) {
            System.out.println("Comando: Girar derecha.");
            // Lógica para girar
            enviarRespuestaAccion();
        } else if (mensaje.equals("IZQUIERDA")){
            System.out.println("Comando: Girar izquierda.");
            // Lógica para girar
            enviarRespuestaAccion();
        }
         else {
            System.out.println("Mensaje no reconocido: " + mensaje);
        }
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