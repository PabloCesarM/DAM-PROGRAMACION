package Serializacion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej2LecturaFicheros {
    public static void main(String[] args) {
        leer();

    }

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
}
