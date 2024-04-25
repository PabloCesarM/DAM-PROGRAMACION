package Ejercicios;
import java.io.*;

public class FicherosE1 {

    public static void main(String[] args) {
//        Ejercicio 1.-
// Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro llamado “invertido.txt”, en el que se
// guardarán las frases del primero pero invertidas.
// Mostrar en pantalla el nuevo fichero.
// Ejemplo:
// texto.txt Esto es un ejemplo
// invertido.txt olpmeje nu se otsE

        leer();
        escribir(leer());
    }

    public static String leer() {
        FileReader invertir = null;
        String st;

        try {
            invertir = new FileReader("C:\\dir1\\d1\\f1.txt");
            try {
                StringBuilder cadena = new StringBuilder();
                int c;
                char j;

                do {
                    c = invertir.read();
                    j = (char) c;
                    if (c != -1) {
                        cadena.append(j);
                    }
                } while (c == -1);

                cadena.reverse();
                st = cadena.toString();
            } finally {
                invertir.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return st;
    }

    public static void escribir(String cad) {
        String cadena = "\ncontenido añadido";
        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("C:\\dir1\\d1\\f1.txt", true);
            for (int i = 0; i < cadena.length(); i++) {
                escribiendo.write(cadena.charAt(i));
            }

            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /**/

    }


}
