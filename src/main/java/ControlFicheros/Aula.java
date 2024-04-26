package ControlFicheros;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula {
//ATRIBUTOS
    private List<Alumno> alumnos;
    private int numalumnos; //atributo para controlar el n�mero real de elementos que tiene nuestro almac�n

    /**     * Constructor del Almac�n con un determinado tamano     */
    public Aula(int tamano) {
        alumnos = new ArrayList<Alumno>(tamano);
        numalumnos = 0;

    }

    /**     * Comprueba si el almac�n est� vacio
     * @return true si est� vacio     */
    public boolean estaVacio() {
        return alumnos.isEmpty();
    }

    /**     * Comprueba si el almac�n est� lleno
     * @return     */
    public boolean estaLLeno() {
        return numalumnos == alumnos.size();
    }

    /**     * Anade un nuevo elemento al almac�n si hay sitio
     * @param valor a anadir al almac�n     */
    public void add(Alumno alumno) {
        if (!this.estaLLeno()) {
            alumnos.add(alumno);
            numalumnos++;
        }
    }

    /**     * Elimina un elemento del almac�n si est� en el almacen
     * @param valor
     * @return true si elimina el elemento, false en caso contrario     */
    public boolean eliminar(Alumno alumno) {
        return alumnos.remove(alumno);
    }


    /**     * Imprime por pantalla los elementos del almac�n     */
    public void informacionAlumnos() {
        System.out.println("El aula tiene los siguientes alumnos:");
        for (int j = 0; j < alumnos.size(); j++) {
            System.out.println(alumnos.get(j).toString() + " ");
        }
    }


    //método para escribir alumnoos en un fichero
    public void escribirAlumnos(String nombreFich) {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = null;
        BufferedReader leer = null;
        String nombre, apellido, calle ;
        int anio, numeroAlumnos, alumCreados = 0, numeroDir;

        try {
            fw = new FileWriter(nombreFich, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Indique cuantos alumnos va a escribir: ");
            numeroAlumnos = sc.nextInt();

            do {
                System.out.println("Ingresar nombre: ");
                sc.nextLine();
                nombre = sc.nextLine();
                System.out.println("Ingrese su apellido: ");
                apellido = sc.nextLine();
                System.out.println("Ingrese su año de nacimiento: ");
                anio = sc.nextInt();
                System.out.println("Ingrese su calle: ");
                sc.nextLine();
                calle = sc.nextLine();
                System.out.println("Ingrese su número: ");
                numeroDir = sc.nextInt();

                bw.write("Nombre: " +nombre + " Apellido: " + apellido + " Año de nacimiento: " + anio +
                            " Direccción: " + calle + ", " + numeroDir + "\n");
                //para que cada alumno este en una línea diferente habría que usar un \n en vez de un tabulador

                alumCreados++;
            } while (alumCreados < numeroAlumnos);

            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //método para leer los alumnoos del fichero
    public void leerAlumnos(String nombreFich){
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(nombreFich);
            br = new BufferedReader(fr);

            do {
                nombreFich = br.readLine();/*lee una linea*/
                if (nombreFich != null) {  /*si está vacio*/
                    System.out.println(nombreFich);
                }
            }while (nombreFich != null);
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
