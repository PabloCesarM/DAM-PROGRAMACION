package Aleatorio;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Aleatorio1 {
    static RandomAccessFile fich = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        try {
            fich = new RandomAccessFile("C:\\dir1\\enteros.dat", "rw");
            mostrarFich();
            System.out.println("Ingresar número entero para añadir al final del fichero");
            numero = sc.nextInt();
            fich.seek(fich.length());/*nos colocamos al final del fichero // */
            fich.writeInt(numero);
            mostrarFich();
            fich.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void mostrarFich() {
        /*va a ir leyendo y lo la va escribiendo*/
        int numero;
        try {
            fich.seek(0);
            while (true) {
                numero = fich.readInt();
                System.out.println(numero);
            }
        } catch (EOFException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}