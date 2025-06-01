package PaqueteRobot;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa un altavoz
 * subclase de ModuloEstaticoActuacion
 * tiene una relacion de agregacion uno a muchos con clase Actuador
 * tiene un metodo abstracto realizarAccion
 */
public class Altavoz extends ModuloEstaticoActuacion implements InterfazActuador {
    
    // ATRIBUTOS
    private List<Actuador> actuadores;//Relacion de agregacion
    
    // CONSTRUCTOR
    public Altavoz(int id, String referencia, String descripcion, 
                   int largo, int ancho, int profundidad) {
        super(id, referencia, descripcion, largo, ancho, profundidad);
        this.actuadores = new ArrayList<>();
    }
    
    // GETTERS
    public List<Actuador> getActuadores() { return actuadores; }
    
    // SETTERS
    public void setActuadores(List<Actuador> actuadores) { this.actuadores = actuadores; }
    public void agregarActuador(Actuador actuador) { this.actuadores.add(actuador); }
    public void eliminarActuador(Actuador actuador) { this.actuadores.remove(actuador); }
    
    // OPERACIONES
    @Override
    public int realizarAccion() {
        int resultado = 1; // Inicialmente asumimos éxito
        System.out.println("Altavoz iniciando acción en todos los actuadores...");
        
        for (Actuador actuador : actuadores) {
            int resultadoActuador = actuador.realizarAccion();
            if (resultadoActuador != 1) { // Si algún actuador falla
                resultado = 0;
            }
        }
        return resultado;
    } //heredada de ModuloEstaticoActuacion y propagada a los actuadores
}