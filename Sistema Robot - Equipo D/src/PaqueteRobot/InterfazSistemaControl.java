package PaqueteRobot;
import java.util.List;

public interface InterfazSistemaControl {
    public boolean enviarRespuestaAccion();
    public List<String> gestionarSolucion(int id);
}