package ControlFicheros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAlumnos {

    public static void main(String[] args) {
        //Variables
        Scanner sc = new Scanner(System.in);
        String nombreFich;
        int tamano;
        try {
            //se piden los datos necesarios para crear un constructor de aula
            System.out.println("Indique el tamaño de la clase: ");
            tamano = sc.nextInt();

            //se crea el objeto aula
            Aula a1 = new Aula(tamano);

            //se pide una direccion donde guardar los datos de los alumnos que formen el aula
            System.out.println("Indique la dirección donde donde quiere que se guarde el fichero con el contenido " +
                    "de los alumnos del aula (Ejemplo: C:/dir1/alumnos.txt ):");
            sc.nextLine();
            nombreFich = sc.nextLine();

            //se llama al metodo para alumnos al fichero de los datos de los alumnos
            a1.escribirAlumnos(nombreFich);

            //se llama al método para leer el archivo donde estan los datos de los alumnos
            a1.leerAlumnos(nombreFich);

        }catch (InputMismatchException e){
            System.out.println("Has introducido un caracter invalido donde debe introducir un número");
        }




    }



}
