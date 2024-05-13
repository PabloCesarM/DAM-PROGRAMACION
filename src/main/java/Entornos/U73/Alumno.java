package Entornos.U73;

import java.util.Scanner;

public class Alumno {
    private String nombreUsuario;
    private String contrasenia;

    public Alumno(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = "a" + nombreUsuario;
        this.contrasenia = contrasenia;
    }

    //getter/setter
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = "a" + nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    //método para consultar notas
        public static void consultarNotas() {
            Scanner sc = new Scanner(System.in);
            boolean salir = false;

            try {
                while (!salir) {
                    System.out.println("Elija una opción:");
                    System.out.println("1. Consultar notas de una materia");
                    System.out.println("2. Consultar todas las notas");
                    System.out.println("0. Salir");
                    int opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.println("Opción seleccionada: Consultar notas de una materia");
                            System.out.print("Ingrese el nombre de la materia: ");
                            String materia = sc.nextLine();
                            consultarNotasMateria(materia);
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Consultar todas las notas");
                            consultarTodasLasNotas();
                            break;
                        case 0:
                            System.out.println("Ha salido del sistema");
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                }
            } catch (RuntimeException e) {
                System.out.println("Ha introducido una letra donde deberia introducir un número.");
            }
        }

        // método para consultar las notas de una materia
        public static void consultarNotasMateria(String materia) {
            System.out.println("Consultando notas de la materia: " + materia);

        }

        // método para consultar todas las notas
        public static void consultarTodasLasNotas() {
            System.out.println("Consultando todas las notas.");

        }


}
