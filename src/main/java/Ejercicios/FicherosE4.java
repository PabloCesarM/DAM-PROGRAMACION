package Ejercicios;

import java.io.*;

public class FicherosE4 {

    public static void main(String[] args) {
//    Hacer un programa, que modifique el fichero “texto.txt”, insertando un * delante de cada vocal.
//    Mostrar el fichero “texto.txt” resultante.
//            Ejemplo :
//    Inicialmente Texto.txt Voy a hacer una prueba
//    Finalmente Texto.txt V*oy *a h*ac*er *un*a pr*u*eb*a
        String fileOriginal = "texto.txt";
        String archivoSalida = "texto_encriptado.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {

            int caracter;
            while ((caracter = br.read()) != -1) {
                if (Character.isLetter(caracter)) {
                    char nuevoCaracter = encriptarCaracter((char) caracter);
                    bw.write(nuevoCaracter);
                } else {
                    // Si no es una letra, escribir el mismo carácter en el archivo de salida
                    bw.write(caracter);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }

        System.out.println("El archivo se ha encriptado con éxito.");

    }


    // Método para encriptar un carácter
    private static char encriptarCaracter(char c) {
        // Si es una letra minúscula
        if (c >= 'a' && c <= 'z') {
            return (char) ('a' + (c - 'a' + 3) % 26);
        }
        // Si es una letra mayúscula
        else if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + (c - 'A' + 3) % 26);
        }
        // Si no es una letra, devolver el mismo carácter
        else {
            return c;
        }
    }


}
