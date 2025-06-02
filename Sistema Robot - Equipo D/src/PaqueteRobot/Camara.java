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
    
    @Override
    public int procesarDatos(Object rawData) {
        if (rawData instanceof List){
            List<?> dataList = (List<?>) rawData;
            if (dataList.isEmpty()) {
                return -1;
            }
            Object firstElement = dataList.get(0);
            if (firstElement instanceof String) {
                switch ((String) firstElement) {
                    case "MASCOTA":
                        return 1;
                    case "OBSTACULO":
                        return 2;
                    case "LIBRE":
                        return 3;
                    case "FUERA DE LOS LIMITES":
                        return 4;
                    case "CARACTER NO RECONOCIDO":
                        return 5;
                    default:
                        System.out.println("Advertencia: String de datos no reconocido: " + firstElement);
                        return -1;
                }
            } else {
                System.out.println("Advertencia: Elemento de la lista no es un String.");
                return -1;
            }
        } return -1; // Si rawData no es una lista, retornar -1  
    }

    @Override
    public Object captarInformacion(int rowChar, int colChar, char[][] matriz) {
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