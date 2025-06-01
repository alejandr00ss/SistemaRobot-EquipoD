package PaqueteRobot;

public class Sensor implements InterfazSensor {
    
    private int id;
    private String tipo;
    private String descripcion;

    // CONSTRUCTOR
    public Sensor(int id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Object captarInformacion(char rowChar, char colChar, char[][] matriz) {
        int r = rowChar; 
        int c = colChar;

        // Boundary checks
        if (matriz == null || r < 0 || r >= matriz.length || matriz.length == 0 || c < 0 || c >= matriz[0].length) {
            System.err.println("Sensor (ID: " + id + ", Tipo: " + tipo + "): Cordenadas (" + (int)r + "," + (int)c + ") estan fuera de los limites.");
            switch (this.tipo) {
                case "PROXIMIDAD":
                    return false; // Out of bounds, assume no obstacle
                case "CAMARA": 
                    return "FUERA DE LOS LIMITES";
                default:
                    return null;
            }
        }

        char cellContent = matriz[r][c];

        switch (this.tipo) {
            case "PROXIMIDAD":
                // Detects 'O' (Obstacle) or 'P' (Pet) [cite: 27]
                if (cellContent == 'O' || cellContent == 'P') {
                    return true; // Obstacle detected
                } else {
                    return false; // No obstacle
                }
            case "CAMARA":
                // Identifies 'P' (Pet) or 'O' (Obstacle) [cite: 28]
                if (cellContent == 'P') {
                    return "MASCOTA";
                } else if (cellContent == 'O') {
                    return "OBSTACULO";
                } else if (cellContent == '.') { // Assuming ' ' is clear space
                    return "LIBRE";
                } else {
                    return "CARACTER NO RECONOCIDO"; // Cell has an unrecognized character
                }
            default:
                System.err.println("Sensor (ID: " + id + "): tipo de sensor desconocido: " + this.tipo);
                return null; // Invalid sensor type or unhandled type
        }
    }
}