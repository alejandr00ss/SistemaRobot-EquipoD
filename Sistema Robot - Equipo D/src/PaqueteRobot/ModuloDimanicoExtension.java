package PaqueteRobot;

public class ModuloDimanicoExtension extends ModuloDinamico {
    
    public ModuloDimanicoExtension(int id, String referencia, String descripcion, int largo, int ancho, int profundidad) {
        super(id, referencia, descripcion, largo, ancho, profundidad);
    }

    public int moverse(float[] movimiento){
        return 0;
    }
}