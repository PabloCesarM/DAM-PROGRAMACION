package Entornos.U73;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGestionNotas {
    public static void main(String[] args) {

        menu();


    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String nombreUsuario="", contrasenia="";

        try {
            while (!salir) {
                System.out.println("Bienvenido al sistema de gestión de notas.");
                System.out.println("Seleccione una opción:");
                System.out.println("1. Registrarse");
                System.out.println("2. Acceder");
                System.out.println("0. Salir");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Opción seleccionada: Registrarse");

                        break;
                    case 2:
                        System.out.println("Opción seleccionada: Acceder");
                        System.out.println("Ingrese su nombre de usuario");
                        nombreUsuario = sc.nextLine();
                        System.out.println("Ingrese su contraseña");
                        contrasenia = sc.nextLine();
                        acceder(nombreUsuario,contrasenia);

                        break;
                    case 0:
                        System.out.println("Ha salido del sistema");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Ha introducido una letra donde deberia introducir un número.");
        }


        sc.close();
    }

    //metodo para identificar si es alumno o profesor
    public static void acceder(String usuario, String contraseña) {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);

        if (usuario.startsWith("p")) {
            try {
                while (!salir) {
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Poner o modificar notas");
                    System.out.println("2. Listar notas");
                    System.out.println("0. Salir");
                    int opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.println("Opción seleccionada: Poner o modificar notas");
                            //metodo para poner o modificar notas
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Poner o modificar notas");
                            //metodo para listar notas
                            break;
                        case 0:
                            System.out.println("Ha salido del sistema");
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                            break;
                    }
                }
            } catch (RuntimeException e) {
                System.out.println("Ha introducido una letra donde deberia introducir un número.");
            }

        } else if (usuario.startsWith("a")) {
            Alumno.consultarNotas();
        }

    }
}
