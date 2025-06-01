package PaqueteRobot;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * tiene una relacion uno a uno con sistema de control, el sistema de control le pasa el mensaje
 * es una composicion con modulo
 * tiene una relacion uno a uno con usuario, el usuario recibe el mensaje
 * tiene otra relacion uno a uno con usuario, el usuario envia el mensaje
 * ademas tiene una relacion reflexiva consigo misma, esta el sistema de comunicacion que
 * recibe el mensaje y otro sistema de comunicacion lo recibe.
 */
public class SistemaComunicacion{

    private int idUsuario;
    private Boolean emisor; //Para resolver la reflexividad
    private Boolean receptor; //Para resolver la reflexividad
    private List<String> listaMensaje = new ArrayList<>();

    // CONSTRUCTOR
    public SistemaComunicacion(int idUsuario) {
        this.idUsuario = idUsuario;
        this.emisor = false;
        this.receptor = false;
    }

    // GETTERS
    public int getIdUsuario(){
        return idUsuario;
    }


    public Boolean getEmisor(){
        return emisor;
    }

    public Boolean getReceptor(){
        return receptor;
    }

    // SETTERS
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }


    public void setEmisor(Boolean emisor){
        this.emisor = emisor;
    }

    public void setReceptor(Boolean receptor){
        this.receptor = receptor;
    }
    
    // OPERACIONES
    public List<String> enviarMensaje(){
        if (emisor == true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el mensaje: ");
            String mensaje = sc.nextLine();
            listaMensaje.add(mensaje);
            return listaMensaje;
        } else {
            System.out.println("El mensaje no se pudo enviar");
            return null;
        }
    }

    public void recibirMensaje(List<String> mensaje){
        if (receptor == true){
            this.listaMensaje = mensaje;
            System.out.println("El mensaje es: " + listaMensaje);
        } else {
            System.out.println("El mensaje no se pudo recibir");
        }
    }
}