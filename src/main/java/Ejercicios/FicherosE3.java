package Ejercicios;

import java.io.*;

public class FicherosE3 {

    public static void main(String[] args) {
/*Realizar un programa que cuente el número de líneas, caracteres
        y palabras que tiene un fichero que se pasará por teclado.
Se debe comprobar que el fichero existe antes de empezar a contar.*/

        contadorLineasCaracteresPalabras();

    }


    public static void contadorLineasCaracteresPalabras() {
        int nLineas = 1, nCaracteres = 0, nPalabras = 1;

        try {
            FileReader fr = new FileReader("C:\\dir1\\f2.txt");
            try {
                int c;
                //mientras el caracter sea distinto de -1 podremos comprobar lo que se pide
                do {
                    c = fr.read();
                    //si el caracter es distinto de cambio de linea contamos un caracter
                    if (c != '\n') {
                        nCaracteres++;
                    }
                    //si el caracter es igual a un cambio de linea o un espacio en blanco se cuenta una palabra
                    if (c == '\n' || c == ' ') {
                        nPalabras++;
                    }
                    //si el caracter es igual al cambio de línea se cuenta una línea
                    if (c == '\n') {
                        nLineas++;
                    }

                } while (c != -1);
                System.out.println("En este fichero hay: \n" + nPalabras + " palabras \n" + nCaracteres + " caracteres \n" + nLineas + " líneas");
                fr.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
