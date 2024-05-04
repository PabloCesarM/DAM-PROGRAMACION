package Ejercicios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FichAccAleatorio1 {

    public static void escribirEnArchivo(String nombreArchivo, int[] referencias, double[] precios) {
        // Verificamos que los dos arrays tengan la misma longitud
        if (referencias.length != precios.length) {
            System.out.println("Error: Los arrays tienen longitudes diferentes");
            return;
        }

        // Creamos un ArrayList para almacenar los datos temporales
        ArrayList<String> datos = new ArrayList<>();

        // Llenamos el ArrayList con los datos formateados (referencia, precio)
        for (int i = 0; i < referencias.length; i++) {
            datos.add(referencias[i] + "," + precios[i]);
        }

        // Abrimos el archivo en modo de escritura
        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            // Escribimos los datos en el archivo
            for (String dato : datos) {
                archivo.writeBytes(dato + System.lineSeparator());
            }
            System.out.println("Datos escritos correctamente en el archivo: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nombreArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + nombreArchivo);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] referencias = {101, 102, 103};
        double[] precios = {10.5, 20.75, 15.99};
        escribirEnArchivo("datos.txt", referencias, precios);
    }
}
