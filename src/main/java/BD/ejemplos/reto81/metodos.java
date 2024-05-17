package BD.ejemplos.reto81;

import java.sql.*;
import java.util.Scanner;

public class metodos {


    //metodo menu
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        int opcion = 9;

        try {
            do {
                System.out.println("Seleccione una opcion:");
                System.out.println("1. Mostrar bases de datos");
                System.out.println("2. Crear base de datos");
                System.out.println("3. Crear tabla");
                System.out.println("4. Insertar datos");
                System.out.println("5. Consultar datos");
                System.out.println("6. Eliminar datos");
                System.out.println("0. Salir");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Opción seleccionada: Mostrar bases de datos");
                        mostrarBases();
                        break;
                    case 2:

                        System.out.println("Opción seleccionada: Crear base de datos");
                        System.out.println("Introduce el nombre de la base de datos");
                        String baseDatos = sc.nextLine();
                        System.out.println("CREATE DATABASE " + baseDatos + ";");
                        break;
                    case 3:
                        System.out.println("Opción seleccionada: Crear tabla");
                        System.out.println("Introduce el nombre de la tabla");
                        String tabla = sc.nextLine();
                        System.out.println("CREATE TABLE " + tabla + ";");

                        break;
                    case 4:
                        System.out.println("Opción seleccionada: Insertar datos");

                        break;
                    case 5:
                        System.out.println("Opción seleccionada: Consultar datos");

                        break;
                    case 6:
                        System.out.println("Opción seleccionada: Eliminar datos");

                        break;
                    case 0:
                        System.out.println("Ha salido del sistema");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            }while (opcion != 0);
        } catch (RuntimeException e) {
            System.out.println("Ha introducido una letra donde deberia introducir un número.");
        }

    }


    //metodo para mostrar bases de datos
    public static void mostrarBases(){
        Scanner sc = new Scanner(System.in);
        //variables
        String url = null;
        String usuario = null;
        String contrasenia = null;
        String instSQLverBDs = null;


        //conexión con la base de datos
        Connection conexion = null;
        try {
            System.out.println("Introduce la url");
            url = sc.nextLine();
            System.out.println("Introduce el usuario");
            usuario = sc.nextLine();
            System.out.println("Introduce la contrasenia");
            contrasenia = sc.nextLine();
            System.out.println("Introduce la instruccion SQL para ver las bases de datos");
            instSQLverBDs = sc.nextLine();

            conexion = DriverManager.getConnection(url, usuario, contrasenia);
            Statement st = conexion.createStatement();

            ResultSet rs = st.executeQuery(instSQLverBDs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
