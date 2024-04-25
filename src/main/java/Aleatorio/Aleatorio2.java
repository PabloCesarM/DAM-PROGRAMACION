package Aleatorio;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Aleatorio2 {
    static RandomAccessFile fich = null;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int posicion;
        long tamanio;
        int numero;

        try {
            fich = new RandomAccessFile("C:\\dir1\\enteros.dat", "rw");
            /*dividir entre cuatro para saber cuantos enteros hay en el fichero*/
            tamanio = fich.length() / 4;
            System.out.println("El fichero tiene " + tamanio + " enteros");
            do {
                System.out.println("Posicion (>=1 y <=" + tamanio + ")");
                posicion = sc.nextInt();
            }while (posicion < 1 || posicion > tamanio);
            posicion--;
            fich.seek(posicion* 4L);
            System.out.println("Valor: " + fich.readInt());
            System.out.println("Ingresa un valor nuevo");
            numero = sc.nextInt();
            /*volver a la posicion que ya hemos leido*/
            fich.seek(fich.getFilePointer()-4);
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
