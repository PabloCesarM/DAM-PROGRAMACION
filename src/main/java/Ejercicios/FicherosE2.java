package Ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FicherosE2 {

    public static void main(String[] args) {
// Realizar un programa que muestre las n primeras líneas del fichero de texto “texto.txt”.
// El valor de n se pedirá al usuario y se tendrá en cuenta que puede ser mayor que el número de filas del fichero.
        Scanner sc = new Scanner(System.in);
        int nLineas = 0, c;
        String st;
        FileReader fr = null;
        char j;

        try {
            fr = new FileReader("C:\\dir1\\f2.txt");
            do {
                System.out.println("¿Cuantas líneas quieres que se muestren?");
                nLineas = sc.nextInt();
            }while (nLineas<0);
            try {
                StringBuilder cadena = new StringBuilder();

                do {
                    c = fr.read();
                    j = (char) c;
                    if (c != -1) {
                        cadena.append(j);
                    }
                } while (c == -1);

                st = cadena.toString();
                System.out.println(st);

                do{
                    if(j == '\n'){
                        nLineas--;
                    }
                }while (nLineas != 0);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                fr.close();;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
