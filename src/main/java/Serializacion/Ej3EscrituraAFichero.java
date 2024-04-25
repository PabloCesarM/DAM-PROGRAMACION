package Serializacion;

import java.io.FileWriter;
import java.io.IOException;

public class Ej3EscrituraAFichero {

    public static void main(String[] args) {

        escribir();
    }

    public static void escribir(){
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
