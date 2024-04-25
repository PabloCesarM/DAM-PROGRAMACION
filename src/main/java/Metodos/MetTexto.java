package metodos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MetTexto {

    public static void main(String[] args) {

    }//fin del main

    //metodo para leer caracter a caracter
    public static void leer() {
        try {
            FileReader entrada = new FileReader("C:\\dir1\\d1\\f1.txt");
            try {
                int c ;
                do {
                    c = entrada.read();
                    if (c!=-1){
                        System.out.println((char) c);
                    }
                }while (c != -1);
                entrada.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para escribir caracter a caracter
    public static void escribir() {
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
    }


}//fin de la clase
