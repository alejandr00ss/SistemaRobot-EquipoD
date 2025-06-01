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

    public void interpretarMensaje(String mensaje){
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
            // Lógica adicional: continuar con la tarea actual.
        } else if (mensaje.equals("ADELANTE")) {
            System.out.println("Comando: Mover adelante.");
            // Lógica para interactuar con actuadores para mover el robot
            // Ejemplo: if (robotPrincipal != null) robotPrincipal.mover(Direccion.ADELANTE);
            enviarRespuestaAccion(); // Confirmar que el comando se está procesando
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
        System.out.println("[SistemaControl Módulo " + idModulo + "] Respuesta de acción enviada (simulado).");
        return true;
    }

    @Override
    public List<String> gestionarSolucion(int idProblema) {
        System.out.println("[SistemaControl Módulo " + idModulo + "] Gestionando solución para ID de problema: " + idProblema);
        List<String> soluciones = new ArrayList<>();
        switch (idProblema) {
            case 1: // Suponiendo que 1 es para "OBJETO"
                soluciones.add("Evaluar dimensiones del objeto.");
                soluciones.add("Intentar rodear por la derecha si hay espacio.");
                soluciones.add("Intentar rodear por la izquierda si hay espacio.");
                soluciones.add("Notificar al usuario y esperar instrucciones.");
                break;
            case 2: // Suponiendo que 2 es para "BATERIA_BAJA"
                soluciones.add("Buscar estación de carga más cercana.");
                soluciones.add("Reducir consumo de energía (apagar módulos no esenciales).");
                soluciones.add("Notificar al usuario sobre nivel de batería bajo.");
                break;
            // Otros casos para diferentes IDs de problemas
            default:
                soluciones.add("No hay soluciones predefinidas para el ID de problema: " + idProblema);
                break;
        }
        return soluciones;
    }
}