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
    private static int posX = TAMANO_MATRIZ / 2;  // Posición inicial central
    private static int posY = TAMANO_MATRIZ / 2;
    private static char direccion = '^';  // '^': arriba, 'v': abajo, '<': izquierda, '>': derecha
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
            menuUsuario();
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
        Robot robotUsuario = new Robot("AAaaa",alias,"Robot",idUsuario);

        ModuloDinamicoExtension extension = new ModuloDinamicoExtension( 32,"AAaaa", "ModuloDinamicoExtension", 32, 32, 32);
        
        ModuloDinamicoRotacion rotacion = new ModuloDinamicoRotacion( 32,"AAaaa", "ModuloDinamicoRotacion", 32, 32, 32);
           
        ModuloDinamicoHelicoidal helicoidal = new ModuloDinamicoHelicoidal( 32,"AAaaa", "ModuloDinamicoHelicoidal", 32, 32, 32);
        
        Camara camara = new Camara( 32,"AAaaa", "Camara", 32, 32, 32);
        
        SensorProximidad sensorProximidad = new SensorProximidad( 32,"AAaaa", "SensorProximidad", 32, 32, 32);
        
        Altavoz altavoz = new Altavoz( 32,"AAaaa", "Altavoz", 32, 32, 32);

        robotUsuario.agregarModulo(extension);
        robotUsuario.agregarModulo(rotacion);
        robotUsuario.agregarModulo(helicoidal);
        robotUsuario.agregarModulo(camara);
        robotUsuario.agregarModulo(sensorProximidad);
        robotUsuario.agregarModulo(altavoz);
        
        extension.setSistemaControl(new SistemaControl(extension.getId()));
        rotacion.setSistemaControl(new SistemaControl(rotacion.getId()));
        helicoidal.setSistemaControl(new SistemaControl(helicoidal.getId()));
        camara.setSistemaControl(new SistemaControl(camara.getId()));
        sensorProximidad.setSistemaControl(new SistemaControl(sensorProximidad.getId()));
        altavoz.setSistemaControl(new SistemaControl(altavoz.getId()));

        extension.setSistemaComunicacion(new SistemaComunicacion(idUsuario,(extension.getId())));
        rotacion.setSistemaComunicacion(new SistemaComunicacion(idUsuario,(rotacion.getId())));
        helicoidal.setSistemaComunicacion(new SistemaComunicacion(idUsuario,(helicoidal.getId())));
        camara.setSistemaComunicacion(new SistemaComunicacion(idUsuario,(camara.getId())));
        sensorProximidad.setSistemaComunicacion(new SistemaComunicacion(idUsuario,(sensorProximidad.getId())));
        altavoz.setSistemaComunicacion(new SistemaComunicacion(idUsuario,(altavoz.getId())));
        
        //añadir sensores
        Sensor sensorVisual = new Sensor(35654,"Visual","Sensor de vision");
        Sensor sensorInfrarrojo = new Sensor(23564,"Proximidad","Sensor de proximidad");

        camara.agregarSensor(sensorVisual);
        camara.setNumeroSensores(camara.getSensores().size());

        sensorProximidad.agregarSensor(sensorInfrarrojo);
        sensorProximidad.setNumeroSensores(sensorProximidad.getSensores().size());

        //añadir actuadores
        Actuador bocina = new Actuador(35654,"Bocina","Actuador de bocina");
        altavoz.agregarActuador(bocina);
        altavoz.setNumeroActuadores(altavoz.getActuadores().size());

        robots.add(robotUsuario);
        
        System.out.println("Robot asignado exitosamente");
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

        for (Robot robot : robots) {
            if (robot.getIdUsuario() == idUsuario) {
                System.out.println("Bienvenido, " + robot.getAlias() + "!");
                robot.encender();
                actualizarMatriz(robot);
            }
        }
        
    }


//Parte que controla la simulacion del robot y la matriz donde se mueve el robot, imprime mascota y obstaculos
//----------------------------------------------------------------------------------------------------------------------------------------
    private static void inicializarMatriz() {
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                matriz[i][j] = '.';
            }
        }
        matriz[posX][posY] = direccion;  // Posición inicial del robot
    }

    private static void colocarObstaculos() {
        matriz[2][2] = 'O';  // Obstáculo
        matriz[5][7] = 'O';
        matriz[8][3] = 'O';
        matriz[3][6] = 'P';  // Mascota
    }

    private static void imprimirMatriz() {
        System.out.println("\nEstado del entorno:");
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void girarDerecha() {
        switch (direccion) {
            case '^': direccion = '>'; break;
            case '>': direccion = 'v'; break;
            case 'v': direccion = '<'; break;
            case '<': direccion = '^'; break;
        }
        matriz[posX][posY] = direccion;
        System.out.println("Dirección actual: " + direccion);
    }

    private static void girarIzquierda() {
        switch (direccion) {
            case '^': direccion = '<'; break;
            case '<': direccion = 'v'; break;
            case 'v': direccion = '>'; break;
            case '>': direccion = '^'; break;
        }
        matriz[posX][posY] = direccion;
        System.out.println("Dirección actual: " + direccion);
    }

    private static void avanzar(Robot robot, char xprox, char yprox, char[][] matriz) {

        int id = 0;
        SensorProximidad sensorProximidad = null;
        Camara camara = null;
        Altavoz altavoz = null;
        ModuloDinamicoExtension extension = null;
        ModuloDinamicoRotacion rotacion = null;
        ModuloDinamicoHelicoidal helicoidal = null;

        for(Modulo modulo : robot.getModulos()){
            if(modulo instanceof SensorProximidad){
                sensorProximidad = (SensorProximidad) modulo;
            }
            if (modulo instanceof Camara){
                camara = (Camara) modulo;
            }
            if (modulo instanceof Altavoz){
                altavoz = (Altavoz) modulo;
            }
            if (modulo instanceof ModuloDinamicoExtension){
                extension = (ModuloDinamicoExtension) modulo;
            }
            if (modulo instanceof ModuloDinamicoRotacion){
                rotacion = (ModuloDinamicoRotacion) modulo;
            }
            if (modulo instanceof ModuloDinamicoHelicoidal){
                helicoidal = (ModuloDinamicoHelicoidal) modulo;
            }
        }
        
        inicializarMatriz();
        colocarObstaculos();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Presione w para avanzar");
        System.out.println("Presione a para girar a la izquierda");
        System.out.println("Presione d para girar a la derecha");
        char opcion = scanner.next().charAt(0);

        if (opcion == 'w'){
            sensorProximidad.getSistemaComunicacion().setReceptor(true);
            sensorProximidad.getSistemaComunicacion().recibirMensaje("Avanzar");
            sensorProximidad.getSistemaComunicacion().setReceptor(false);
            sensorProximidad.getSistemaComunicacion().setEmisor(true);
            sensorProximidad.getSistemaComunicacion().enviarMensaje("Avanzar", sensorProximidad.getId());
            sensorProximidad.getSistemaControl().interpretarMensaje("Avanzar");
        }

        if (encontrado instanceof List<?>) {
            List<?> lista = (List<?>) encontrado;
            if (!lista.isEmpty()) {
                for (Object obj: lista) {
                    if (obj instanceof Boolean){
                        int id = sensorProximidad.procesarDatos(obj)
                    }
                }
            }
        }
    }


    public static void actualizarMatriz(Robot robot) {
        inicializarMatriz();
        colocarObstaculos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            imprimirMatriz();
            System.out.println("\nOpciones:");
            System.out.println("1. Mover adelante");
            System.out.println("2. Girar derecha");
            System.out.println("3. Girar izquierda");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}