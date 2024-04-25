package Ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FicherosE5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una palabra:");
        String palabra = sc.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader("parrafo.txt"));
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                // Dividimos la línea en palabras utilizando el espacio como delimitador
                String[] palabrasEnLinea = linea.split(" ");
                for (String palabraEnLinea : palabrasEnLinea) {
                    // Comparamos cada palabra con la palabra ingresada por el usuario
                    // Ignoramos mayúsculas y minúsculas usando equalsIgnoreCase()
                    if (palabraEnLinea.equalsIgnoreCase(palabra)) {
                        contador++;
                    }
                }
            }
            br.close();

            System.out.println("La palabra '" + palabra + "' aparece " + contador + " veces en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
