package PaqueteRobot;

public class ModuloDinamicoHelicoidal extends ModuloDinamico {

    public ModuloDinamicoHelicoidal(int id, String referencia, String descripcion, int largo, int ancho, int profundidad) {
        super(id, referencia, descripcion, largo, ancho, profundidad);
    }

    public int moverse(float[] movimiento){
        return 0;//Logica a implementar
    }

    @Override
    public void recibirInfoAccion(int idAccion) {
        //Logica a implementar
    }
}