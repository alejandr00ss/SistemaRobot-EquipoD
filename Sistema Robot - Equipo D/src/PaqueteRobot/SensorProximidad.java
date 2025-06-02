package PaqueteRobot;

import java.util.List;
import java.util.ArrayList;
/**
 * subclase de ModuloEstaticoPercepcion
 * tiene dos metodos abstractos procesarDatos y captarInformacion
 * propaga la funcion de captarInformacion a los sensores
 * tiene una relacion de agregacion con Sensor uno a muchos
 */
public class SensorProximidad extends ModuloEstaticoPercepcion implements InterfazSensor {
    
    // ATRIBUTOS
    private List<Sensor> sensores;//Relacion de agregacion
    
    // CONSTRUCTOR
    public SensorProximidad(int id, String referencia, String descripcion, 
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
    
    // OPERACIONES
    @Override
    public int procesarDatos(Object rawData) {
        if (rawData instanceof List) {
            List<?> dataList = (List<?>) rawData;
            if (dataList.isEmpty()) {
                return 0;
            } 
            Object firstElement = dataList.get(0);
            if (firstElement instanceof Boolean){
                return ((Boolean) firstElement) ? 1 : 0;
            }
        }
        return 0;
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
        System.out.println("SensorProximidad (ID: " + getId() + ") no tiene sensores o la lista está vacía.");
        return null;
    }
}
