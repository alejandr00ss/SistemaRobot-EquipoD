package sistema.robot.equipo.d;

import PaqueteRobot.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class SistemaRobotEquipoD {

    private static final int TAMANO_MATRIZ = 10;
    private static char[][] matriz = new char[TAMANO_MATRIZ][TAMANO_MATRIZ];
    private static Scanner scanner = new Scanner(System.in);
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Robot> robots = new ArrayList<>();




    public static void main(String[] args) {
        menuUsuario();
    }

    private static void menuUsuario() {
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
        System.out.println("Ingrese una opción:");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                registrarse();
                break;
            case 3:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida");
                menuUsuario();
                break;
        }
    }
    
//---------------------------------------------------------------------------------------------------------------------------


    private static void iniciarSesion() {
        System.out.println("Ingrese su Alias:");
        String nombreUsuario = scanner.next();
        System.out.println("Ingrese su id:");
        int idUsuario = scanner.nextInt();
        if (verificarUsuario(nombreUsuario,idUsuario)){
            System.out.println("Inicio de sesión exitoso");
            menuRobot(idUsuario);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private static boolean verificarUsuario(String aliasUsuario, int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getAlias().equals(aliasUsuario) && usuario.getId() == idUsuario) {
                return true; // Retorna true solo si encuentra una coincidencia.
            }
        }
        return false; // Retorna false si no encontró coincidencias después de recorrer toda la lista.
    }

    private static void registrarse() {
        System.out.println("Ingrese su Alias:");
        String aliasUsuario = scanner.next();
        System.out.println("Ingrese su id:");
        int idUsuario = scanner.nextInt();
        System.out.println("Ingrese su tipo de usuario");
        String tipoUsuario = scanner.next();
        usuarios.add(new Usuario(idUsuario,aliasUsuario, tipoUsuario));
        System.out.println("Registro exitoso");
        asignarRobotUsuario(idUsuario);
        menuUsuario();
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------



    private static void asignarRobotUsuario(int idUsuario) {
        System.out.println("Ingrese el alias del robot:");
        String alias = scanner.next();
        robots.add(new Robot("AAaaa",alias,"Robot",idUsuario));
    }

    private static void menuRobot(int idUsuario) {
        System.out.println("Bienvenido al menú del robot");
        System.out.println("1. Cambiar alias del robot");
        System.out.println("2. Ingresar a la simulación");
        System.out.println("3. Cerrar sesión");
        System.out.println("4. Salir del programa");
        System.out.println("Ingrese una opción:");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                cambiarAlias(idUsuario);
                break;
            case 2:
                ingresarSimulacion(idUsuario);
                break;
            case 3:
                menuUsuario();
                break;
            case 4:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
        }
    }

    private static void cambiarAlias(int idUsuario) {
        System.out.println("Ingrese el nuevo alias:");
        String alias = scanner.next();
        for (Robot robot : robots) {
            if (robot.getIdUsuario() == idUsuario) {
                robot.setAlias(alias);
                System.out.println("Alias cambiado exitosamente");
                menuRobot(idUsuario);
            }
        }
    }

    private static void ingresarSimulacion(int idUsuario) {
        System.out.println("Ingresando a la simulación...");

        inicializarMatriz();
        colocarObstaculos();
        colocarRobot();
        actualizarMatriz();
    }


    private static void inicializarMatriz() {
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                matriz[i][j] = '.';
            }
        }
    }
    private static void imprimirMatriz() {
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void colocarObstaculos() {
        // Colocar algunos obstáculos fijos
        matriz[2][2] = 'O'; // Obstáculo
        matriz[5][7] = 'O'; // Obstáculo
        matriz[8][3] = 'O'; // Obstáculo
        matriz[3][6] = 'P'; // Mascota (Pet)
    }

    private static void colocarRobot() {
        Random random = new Random();
        int x = random.nextInt(TAMANO_MATRIZ);
        int y = random.nextInt(TAMANO_MATRIZ);
        matriz[x][y] = 'R';
    }

    private static void moverRobot() { //Parte a implementar con los módulos 
        System.out.println("Ingrese la dirección a la que desea mover el robot (arriba, abajo, izquierda, derecha):");
        System.out.println("Desea apagar el robot?");
        System.out.println("S/N");
        String respuesta = scanner.next();
        String direccion = scanner.next();
        int x = 0;
        int y = 0;
        // Buscar la posición actual del robot en la matriz
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                if (matriz[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        // Mover el robot en la dirección especificada
        if (direccion.equals("arriba")) {
            if (x > 0 && matriz[x - 1][y] != 'O') {
                matriz[x][y] = '.';
                matriz[x - 1][y] = 'R';
            } else {
                System.out.println("No se puede mover hacia arriba");
            }
        }
        if (direccion.equals("abajo")) {
            if (x < TAMANO_MATRIZ - 1 && matriz[x + 1][y]!= 'O') {
                matriz[x][y] = '.';
                matriz[x + 1][y] = 'R';
            } else {
                System.out.println("No se puede mover hacia abajo");
            }
        }
        if (direccion.equals("izquierda")) {
            if (y > 0 && matriz[x][y - 1]!= 'O') {
                matriz[x][y] = '.';
                matriz[x][y - 1] = 'R';
            } else {
                System.out.println("No se puede mover hacia la izquierda");
            }
        }
        if (direccion.equals("derecha")) {
            if (y < TAMANO_MATRIZ - 1 && matriz[x][y + 1]!= 'O') {
                matriz[x][y] = '.';
                matriz[x][y + 1] = 'R';
            } else {
                System.out.println("No se puede mover hacia la derecha");
            }
        }
    }

    public static void actualizarMatriz() {
        // Lógica para actualizar la matriz en función de las acciones del robot
        // Por ejemplo, si el robot se mueve, actualizar la posición en la matriz
        // También puedes agregar lógica para otros eventos del robot
        //ejemplo con 7 movimientos del robot
        for (int i = 0; i < 7; i++) {
            imprimirMatriz();
            moverRobot();
        }
    }
}