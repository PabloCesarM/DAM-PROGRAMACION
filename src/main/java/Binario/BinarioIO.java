package Binario;

import java.io.*;
import java.util.Scanner;

public class BinarioIO {

    public static void main(String[] args) {
        int nm;
        double nota;

        Scanner sc = new Scanner(System.in);

        try {
            FileOutputStream fos = new FileOutputStream("C:\\dir1\\notas.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            System.out.println("Ingrese un código de asignatura (0 para acabar)");
            nm = sc.nextInt();
            while (nm !=0){
                dos.writeInt(nm);
                System.out.println("Ingrese una nota: ");
                nota = sc.nextDouble();
                dos.writeDouble(nota);
                System.out.println("Ingrese un código de asignatura (0 para acabar)");
                nm = sc.nextInt();
            }
            dos.close();
            fos.close();

            /*leer lo anterior*/
            FileInputStream fis = new FileInputStream("C:\\dir1\\notas.dat");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0){ /*hay datos disponibles*/
                nm = dis.readInt();
                nota = dis.readDouble();
                System.out.println(nm + "\t" + nota);
            }
            dis.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
