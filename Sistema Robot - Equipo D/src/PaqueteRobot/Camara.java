package PaqueteRobot;

import java.util.List;
import java.util.ArrayList;
/**
 * subclase de ModuloEstaticoPercepcion
 * tiene dos metodos abstractos procesarDatos y captarInformacion
 * propaga la funcion de captarInformacion a los sensores
 * tiene una relacion de agregacion con Sensor uno a muchos
 */
public class Camara extends ModuloEstaticoPercepcion implements InterfazSensor{
    
    // ATRIBUTOS
    private List<Sensor> sensores;//Relacion de agregacion
    
    // CONSTRUCTOR
    public Camara(int id, String referencia, String descripcion, 
                   int largo, int ancho, int profundidad) {
        super(id, referencia, descripcion, largo, ancho, profundidad);
        this.sensores = new ArrayList<>();
    }
    
    // GETTERS
    
    public List<Sensor> getSensores() { return sensores; }
    
    
    // SETTERS
    public void setSensores(List<Sensor> sensores) { this.sensores = sensores; }
    public void agregarSensor(Sensor sensor) { this.sensores.add(sensor); }
    public void eliminarSensor(Sensor sensor) { this.sensores.remove(sensor); }


    //METODOS HEREDADOS

    
    // O
    @Override
    public int procesarDatos(Object rawData) {

        if (rawData instanceof String) {
            String data = (String) rawData;

            if ("MASCOTA".equals(data)) {
                return 1;
            } else if ("OBSTACULO".equals(data)) {
                return 2;
            } else if ("LIBRE".equals(data)) {
                return 3;
            } else if ("FUERA DE LIMITES".equals(data)) {
                return 4;
            } else if ("CARACTER NO RECONOCIDO".equals(data)) {
                return 5;
            } else {
                System.out.println("Advertencia: String de datos no reconocido: " + data);
                return -1;
            }
        } else {
            System.out.println("Advertencia: rawData no es de tipo String.");
            return -1;
        }
    }

    @Override
    public Object captarInformacion(char rowChar, char colChar, char[][] matriz) {
        if (sensores != null && !sensores.isEmpty()) {
            List<Object> resultadosSensores = new ArrayList<>();
            for (Sensor sensor : sensores) {
                Object info = sensor.captarInformacion(rowChar, colChar, matriz);
                if (info != null) {
                    resultadosSensores.add(info);
                }
            }
            if (!resultadosSensores.isEmpty()) {
                return resultadosSensores;
            }
        }
        System.out.println("Cámara (ID: " + getId() + ") no tiene sensores o la lista está vacía.");
        return null;
    }
}