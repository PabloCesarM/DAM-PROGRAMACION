package Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FicherosE2v2 {
    public static void main(String[] args) {
// Realizar un programa que muestre las n primeras líneas del fichero de texto “texto.txt”.
// El valor de n se pedirá al usuario y se tendrá en cuenta que puede ser mayor que el número de filas del fichero.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de líneas a mostrar: ");
        int nLineas = scanner.nextInt();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\dir1\\f2.txt"))) {
            String line;
            int contador = 0;
            while ((line = br.readLine()) != null && contador < nLineas) {
                System.out.println(line);
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

