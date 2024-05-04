package Ejercicios;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FichAccAleatorio3 {
    /*3. Realizar un método que reciba por parámetro el nombre de un fichero que almacena una
    serie de referencias y precios de artículos y actualice los precios de forma que los superiores
    a 100 euros se decrementen en un 50% y los inferiores se incrementen en un 50%.
    El método capturará y tratará todas las excepciones que puedan producirse.*/

    public static void main(String[] args) {
        actualizarPrecios("datos.txt");
    }

    public static void actualizarPrecios(String nombreArchivo) {
        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            String linea;
            long posicion = 0;
            while ((linea = archivo.readLine()) != null) {
                // Dividimos la línea en referencia y precio
                String[] partes = linea.split(",");
                int referencia = Integer.parseInt(partes[0]);
                double precio = Double.parseDouble(partes[1]);

                // Actualizamos el precio según las condiciones dadas
                if (precio > 100) {
                    precio *= 0.5; // Decrementar un 50% para precios superiores a 100 euros
                } else {
                    precio *= 1.5; // Incrementar un 50% para precios inferiores o iguales a 100 euros
                }

                // Regresamos al inicio de la línea en el archivo
                archivo.seek(posicion);
                // Escribimos el precio actualizado
                archivo.writeBytes(String.format("%d,%.2f%n", referencia, precio));

                // Movemos la posición al inicio de la siguiente línea
                posicion = archivo.getFilePointer();
            }
            System.out.println("Precios actualizados correctamente en el archivo: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nombreArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + nombreArchivo);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: El archivo no tiene el formato esperado.");
            e.printStackTrace();
        }
    }


}

