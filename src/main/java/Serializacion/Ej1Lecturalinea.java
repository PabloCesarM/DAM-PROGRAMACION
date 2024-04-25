import java.io.IOException;

public class Ej1Lecturalinea {
    public static void main(String[] args) {
        int c, contador = 0;
        while (true) {
            try {
                if (!((c = System.in.read()) != '\n')) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            /*para meter el try catch nos colocamos encima del error, danmos a more actions
            y seleccionamos la opcion de surround con try catch*/
            contador++;
            System.out.println((char) c);
        }
        System.out.println("Numero de caracteres: " + contador);
    }
}
