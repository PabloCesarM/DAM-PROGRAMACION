
import java.io.*;
import java.util.Scanner;

public class BufferedPrintWriter {

    public static void main(String[] args) {
        String texto;
        Scanner sc = new Scanner(System.in);
        FileWriter fw = null;
        BufferedReader leer = null;
        try {
            fw = new FileWriter("C:\\dir1\\salida.txt", true);
            PrintWriter escribir = new PrintWriter(fw);
            do {
                System.out.println("Ingresar texto: ");
                texto = sc.nextLine();
                if (!texto.isEmpty()) {
                    escribir.println(texto);
                }

            }while (!texto.isBlank());
            escribir.close();

            /*para leer ficheros*/
            FileReader fr = new FileReader("C:\\dir1\\salida.txt");
            leer = new BufferedReader(fr);
            System.out.println("SALIDA");
            do {
                texto = leer.readLine();/*lee una linea*/
                if (texto != null) {  /*si está vacio*/
                    System.out.println(texto);
                }
            }while (texto != null);
            leer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
