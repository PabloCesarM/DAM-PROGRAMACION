package BD.ejemplos;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Final3Pablo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //preguntamos si se desea crear el fichero
        System.out.println("Desea crear el fichero ciudades.bin (S/N): ");
        char respuesta = sc.next().toUpperCase().charAt(0);
        if (respuesta == 'S') {
            insertarDatosFichero();
        }

        //preguntar si se desea añadir los valores de densidad de poblacion y riqueza
        System.out.println("Desea añadir los valores de densidad de poblacion y riqueza (S/N): ");
        respuesta = sc.next().toUpperCase().charAt(0);
        if (respuesta == 'S') {
            insertarDatosFichero();
        }

        //preguntar si se desea leer el fichero
        System.out.println("Desea leer el fichero (S/N): ");
        respuesta = sc.next().toUpperCase().charAt(0);
        if (respuesta == 'S') {
            //se pide la ruta para poder acceder al fichero
            System.out.println("Dime la ruta del fichero (Ejemplo:C:\\dir1\\ciudades.bin): ");
            sc.nextLine();
            String ruta = sc.nextLine();
            visualizarDatosFichero(ruta);
        }

        //EJERCICIO ACCESO A BBDD
        //creamos la variable para la url
        final String url = "jdbc:mysql://localhost:3306/";
        //creamos la variable para el usuario
        final String usuario = "root";
        //creamos la variable para la contrasenia
        final String contrasenia = "admin";
        final String sqlCrearBD = "CREATE DATABASE DatosDeCiudades";
        final String sqlUseBD = "USE DatosDeCiudades";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            Statement st = conexion.createStatement();

            //preguntar si se desea crear la base de datos, puede ya existir
            System.out.println("Desea crear la base de datos (S/N): ");
            respuesta = sc.next().toUpperCase().charAt(0);
            if (respuesta == 'S') {
                st.executeUpdate(sqlCrearBD);
                System.out.println("Base de datos creada");
            }

            //reguntar si se desea crear la tabla, puede ya existir
            System.out.println("Desea crear la tabla ciudades (S/N): ");
            respuesta = sc.next().toUpperCase().charAt(0);
            if (respuesta == 'S') {
                crearBBDDTabla();
                System.out.println("Tabla creada");
            }

            //preguntar si se insertar datos en la tabla, puede ya existir
            System.out.println("Desea insertar datos en la tabla (S/N): ");
            respuesta = sc.next().toUpperCase().charAt(0);
            if (respuesta == 'S') {
                insertarBBDD();
                System.out.println("Datos insertados");
            }

            //preguntar si se desea borrar alguna ciudad, puede ya existir
            System.out.println("Desea eliminar alguna ciudad (S/N): ");
            respuesta = sc.next().toUpperCase().charAt(0);
            while (respuesta == 'S') {
                visualizarBBDD();
                if (respuesta == 'S') {
                    borrarDatos();
                }
                System.out.println("Desea eliminar otra ciudad (S/N): ");
                respuesta = sc.next().toUpperCase().charAt(0);
            } ;

            //visualizar los datos de la tabla
            visualizarBBDD();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    //metodo para crear el fichero e insertar los datos de la tabla
    public static void insertarDatosFichero() {
        Scanner sc = new Scanner(System.in);

        String nombre = "";
        int poblacion = 0;
        int viviendas = 0;
        int renta = 0;
        double extension = 0;
        double densidadPoblacion = 0;
        int riqueza = 0;

        System.out.println("Dime la ruta del fichero (Ejemplo:C:\\dir1\\ciudades.bin): ");
        String ruta = sc.nextLine();

        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            DataOutputStream dos = new DataOutputStream(fos);

            //rellenar el fichero con los datos de la tabla
            nombre = "Las Rozas";
            dos.writeUTF(nombre);
            poblacion = 95071;
            dos.writeInt(poblacion);
            viviendas = 35390;
            dos.writeInt(viviendas);
            renta = 50286;
            dos.writeInt(renta);
            extension = 58.31;
            dos.writeDouble(extension);
            densidadPoblacion = 0;
            dos.writeDouble(densidadPoblacion);
            riqueza = 0;
            dos.writeInt(riqueza);
            nombre = "Colmenar Viejo";
            dos.writeUTF(nombre);
            poblacion = 48614;
            dos.writeInt(poblacion);
            viviendas = 18925;
            dos.writeInt(viviendas);
            renta = 31360;
            dos.writeInt(renta);
            extension = 182.56;
            dos.writeDouble(extension);
            densidadPoblacion = 0;
            dos.writeDouble(densidadPoblacion);
            riqueza = 0;
            dos.writeInt(riqueza);
            nombre = "Tres Cantos";
            dos.writeUTF(nombre);
            poblacion = 46046;
            dos.writeInt(poblacion);
            viviendas = 14460;
            dos.writeInt(viviendas);
            renta = 41048;
            dos.writeInt(renta);
            extension = 37.93;
            dos.writeDouble(extension);
            densidadPoblacion = 0;
            dos.writeDouble(densidadPoblacion);
            riqueza = 0;
            dos.writeInt(riqueza);
            nombre = "Aranjuez";
            dos.writeUTF(nombre);
            poblacion = 58213;
            dos.writeInt(poblacion);
            viviendas = 24790;
            dos.writeInt(viviendas);
            renta = 26386;
            dos.writeInt(renta);
            extension = 201.11;
            dos.writeDouble(extension);
            densidadPoblacion = 0;
            dos.writeDouble(densidadPoblacion);
            riqueza = 0;
            dos.writeInt(riqueza);
            nombre = "Fuenlabrada";
            dos.writeUTF(nombre);
            poblacion = 194669;
            dos.writeInt(poblacion);
            viviendas = 70835;
            dos.writeInt(viviendas);
            renta = 22092;
            dos.writeInt(renta);
            extension = 39.45;
            dos.writeDouble(extension);
            densidadPoblacion = 0;
            dos.writeDouble(densidadPoblacion);
            riqueza = 0;
            dos.writeInt(riqueza);


            //cerrar el fichero
            dos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para modificar el fichero anterior para introducir densidad de poblacion y riqueza
    public static void modificarDatosFichero() {

    }

    //metodo para mostrar el contenido del fichero ciudades.bin
    public static void visualizarDatosFichero(String ruta) {
        String nombre = "";
        int poblacion = 0;
        int viviendas = 0;
        int renta = 0;
        double extension = 0;
        double densidadPoblacion = 0;
        int riqueza = 0;

        FileInputStream fis = null;
        try {

            fis = new FileInputStream(ruta);
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) { /*hay datos disponibles*/
                nombre = dis.readUTF();
                poblacion = dis.readInt();
                viviendas = dis.readInt();
                renta = dis.readInt();
                extension = dis.readDouble();
                densidadPoblacion = dis.readDouble();
                riqueza = dis.readInt();
                System.out.println(nombre + "\t" + poblacion + "\t" + viviendas + "\t" + renta + "\t"
                        + extension + "\t" + densidadPoblacion + "\t" + riqueza);
            }

            dis.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO PARA CREAR LA TABLA
    public static void crearBBDDTabla() {
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String contrasenia = "admin";
        final String sqlUseBD = "USE DatosDeCiudades";
        final String sqlCrearTabla = "CREATE TABLE Ciudades (Nombre VARCHAR(20), Poblacion " +
                "INT, Viviendas INT, Renta INT, Extension DOUBLE, DensidadPoblacion DOUBLE, Riqueza INT)";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            Statement st = conexion.createStatement();
            //utilizar la base de datos
            st.execute(sqlUseBD);
            //utilizar el string para crear la tabla
            st.execute(sqlCrearTabla);
            //cerrar
            st.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para insertar los datos
    public static void insertarBBDD() {
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String contrasenia = "admin";
        final String sqlUseBD = "USE datosDeCiudades";
        final String sqlInsert = "INSERT INTO Ciudades  VALUES ('Las Rozas',95071,35390,50286,58.31,0.0,0)," +
                "('Colmenar Viejo',48614,18925,31360,182.56,0.0,0)," + "('Tres Cantos',46046,14460,41048,37.93,0.0,0)," +
                "('Aranjuez',58213,24790,26386,201.11,0.0,0)," + "('Fuenlabrada',194669,70835,22092,39.45,0.0,0);";
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            Statement st = conexion.createStatement();
            //utilizar la base de datos
            st.execute(sqlUseBD);
            //utilizar el string para insertar los datos
            st.execute(sqlInsert);
            //cerrar
            st.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //metodo para visualizar el contenido de la tabla
    public static void visualizarBBDD() {
        final String sqlUseBD = "USE datosDeCiudades";
        final String sqlSelect = "SELECT * FROM Ciudades";
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String contrasenia = "admin";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            Statement st = conexion.createStatement();
            //utilizar la base de datos
            st.execute(sqlUseBD);

            //mostrar la tabla actualizada
            ResultSet rs = st.executeQuery(sqlSelect);
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + "\t" + rs.getInt("poblacion")
                        + "\t" + rs.getInt("viviendas") + rs.getInt("renta")+
                        "\t" + rs.getDouble("extension") + "\t" + rs.getDouble("densidadPoblacion")
                        + "\t" + rs.getInt("riqueza"));
            }
            //cerrar
            st.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para eliminar ciudades
    public static void borrarDatos() {
        Scanner sc = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String contrasenia = "admin";
        final String sqlUseBD = "USE datosDeCiudades";
        String sqlDelete = "DELETE FROM Ciudades WHERE nombre = ";
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            Statement st = conexion.createStatement();
            //utilizar la base de datos
            st.execute(sqlUseBD);
            //utilizar el string para insertar los datos
            System.out.println("Escribe el nombre de la ciudad que quieres borrar: ");
            String ciudad = sc.nextLine();
            st.execute("DELETE FROM Ciudades WHERE nombre = " + ciudad + ";");
            //cerrar
            st.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
