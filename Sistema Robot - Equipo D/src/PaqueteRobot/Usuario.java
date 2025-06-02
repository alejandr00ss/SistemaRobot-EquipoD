package PaqueteRobot;
import java.util.Scanner;

/**
 * Clase Usuario, este le envía y recibe mensajes al sistema de comunicación
 * además, enciende y apaga el robot
 */
public class Usuario {
    // ATRIBUTOS
    private int id;
    private String alias;
    private String tipo;

    // CONSTRUCTOR
    public Usuario(int id, String alias, String tipo) {
        this.id = id;
        this.alias = alias;
        this.tipo = tipo;
    }

    // GETTERS
    public int getId() { return id; }
    public String getAlias() { return alias; }
    public String getTipo() { return tipo; }

    // SETTERS
    public void setId(int id) { this.id = id; }
    public void setAlias(String alias) { this.alias = alias; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    // OPERACIONES
    public String[] enviarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el destinatario: ");
        String destino = sc.nextLine();
        System.out.println("Ingrese el contenido del mensaje: ");
        String contenido = sc.nextLine();
        sc.close();
        return new String[] { destino, contenido };
    }
    
    public void recibirMensaje(String[] mensaje) {
        System.out.println(mensaje[0] + " " + mensaje[1]);
    }
}