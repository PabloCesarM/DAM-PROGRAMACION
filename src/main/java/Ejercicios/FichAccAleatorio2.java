package Ejercicios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FichAccAleatorio2 {
    /*Escribir un método que reciba por parámetro el nombre de un fichero que almacena una serie de
    referencias y precios de artículos y muestre su contenido por pantalla.*/
    public static void main(String[] args) {
        mostrarContenido("datos.txt");
    }
    public static void mostrarContenido(String nombreArchivo) {
        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "r")) {
            String linea;
            // Leemos el archivo línea por línea y mostramos su contenido por pantalla
            while ((linea = archivo.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nombreArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + nombreArchivo);
            e.printStackTrace();
        }
    }


}
