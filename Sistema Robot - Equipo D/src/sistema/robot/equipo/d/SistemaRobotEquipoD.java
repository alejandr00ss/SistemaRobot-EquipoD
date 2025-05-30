package sistema.robot.equipo.d;

import PaqueteRobot.*;

import java.util.Scanner;

public class SistemaRobotEquipoD {
    public static void main(String[] args) {
        //Crear clase scanner
        Scanner sc = new Scanner(System.in);

        //menú inicial
        System.out.println("Bienvenido al menú principal");
        System.out.println("-------------------------");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear usuario");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Salir");

        int opcion = sc.nextInt();
        
        if (opcion == 1) {
            //Crear usuario
            System.out.println("Ingrese el nombre de usuario:");
            String nombreUsuario = sc.next();
            System.out.println("Ingrese la contraseña:");
            String contrasena = sc.next();
            System.out.println("Ingrese el nombre:");
            String nombre = sc.next();
            System.out.println("Ingrese el apellido:");
            String apellido = sc.next();
            System.out.println("Ingrese el correo electrónico:");
        }

    }
}