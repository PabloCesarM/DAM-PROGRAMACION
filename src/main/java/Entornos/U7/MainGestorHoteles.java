package Entornos.U7;

import java.util.Scanner;

public class MainGestorHoteles {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Bienvenido al sistema de gestión de hoteles.");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrarse");
            System.out.println("2. Acceder");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Registrarse");
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Acceder");
                    //si usuario es cliente
                    // menuCliente();
                    //si usuario es administrrador

                    //else no existe
                    break;
                case 3:
                    System.out.println("Ha salido del sistema");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        sc.close();
    }

    public static void menuCliente() {
        Scanner sc = new Scanner(System.in);
        boolean salir1 = false;

        while (!salir1) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Solicitar resserva");
            System.out.println("2. Visualizar resservas");
            System.out.println("3. Salir");
            int opcion1 = sc.nextInt();
            sc.nextLine();

            switch (opcion1) {
                case 1:
                    System.out.println("Opción seleccionada: Solicitar resserva");
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Visualizar resservas");

                    break;
                case 3:
                    System.out.println("Ha salido del sistema");
                    salir1 = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

    }

    public static void menuAdministrador() {
        Scanner sc = new Scanner(System.in);
        boolean salir1 = false;

        while (!salir1) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. SVisualizar resservas sin factura");
            System.out.println("2. Visualizar resservas sin factura para hoy");
            System.out.println("3. Salir");

        }

    }

}