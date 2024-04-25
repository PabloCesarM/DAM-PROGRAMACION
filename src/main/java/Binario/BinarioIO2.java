package Binario;

import java.io.*;
import java.util.Scanner;

public class BinarioIO2 {

    public static void main(String[] args) {
        /*almacenar dos string*/
        String nm;
        String nota;

        Scanner sc = new Scanner(System.in);

        try {
            FileOutputStream fos = new FileOutputStream("C:\\dir1\\Strings.dat", true);
            DataOutputStream dos = new DataOutputStream(fos);
            System.out.println("Ingrese un String");
            nm = sc.nextLine();
            while (!nm.equals("0")){
                dos.writeUTF(nm);
                System.out.println("Ingrese otro string: ");
                nota = sc.nextLine();
                dos.writeUTF(nota);
                System.out.println("Ingrese 0 para acabar");
                nm = sc.nextLine();
            }
            dos.close();
            fos.close();

            /*leer lo anterior*/
            FileInputStream fis = new FileInputStream("C:\\dir1\\Strings.dat");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0){ /*hay datos disponibles*/
                nm = dis.readUTF();
                nota = dis.readUTF();
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
