package BD.ejemplos;

import java.sql.*;
import java.util.Scanner;

public class ExNoelBD {

    public static void main(String[] args) throws SQLException {

        ejercicioSQL();


    }

    public static void ejercicioSQL() {
        Scanner scanner = new Scanner(System.in);


        //creamos la url con user y admin para conectarnos a la BD
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "admin";


        //SENTENCIAS SQL
        final String instSQLCrearBD = "create database if not exists Tienda_programacion";//CREO LA BD tienda_programacion porque tengo una base de datos que se llama tienda
        final String instSQLUsarBD = "use Tienda_programacion";
        final String instSQLCrearTabla1 = "create table Fabricantes(\n" +
                "  CLFAB int Primary Key,\n" +
                "  Nombre varchar(30)\n" +
                ")ENGINE=InnoDB";

        final String instSQLCrearTabla2 = "create table Articulos(\n" +
                "  CLART int Primary Key,\n" +
                "  Nombre varchar(30),\n" +
                "  Precio int,\n" +
                "  CLFAB int,\n" +
                "  Foreign Key (CLFAB) References Fabricantes(CLFAB)\n" +
                "  ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ")ENGINE=InnoDB;";

        final String insSQLCrearTablaArtFab = "create table ArtFab (id int auto_increment primary key,nombre_art varchar(30),nombre_fab varchar(30),precio int, IVA double)";

        final String instSQLSelectJoin = "select articulos.nombre as nombre_art,fabricantes.nombre as nombre_fab,articulos.precio from articulos" +
                " inner join fabricantes on articulos.clfab=fabricantes.clfab ";
        final String instSQLInsertarFabricantes = "insert into Fabricantes values(1,'Kingston'),(2,'Adata'),(3,'Logitech'),(4,'Lexar'),(5,'Seagate');";

        final String instSQLInsertarArticulos = "insert into Articulos values(1,'Teclado',100,3)," +
                "(2,'Disco Duro 300Gb',500,5),(3,'Mouse',80,3),(4,'Memoria USB',140,4),(5,'Memoria Ram',290,1)," +
                "(6,'Disco Duro Extraible 250 Gb',650,5),(7,'Memoria USB',279,1),(8,'DVD Rom',450,2),(9,'CD Rom',200,2)," +
                "(10,'Tarjeta de Red',180,3)";

        final String instSQLInsertarArtFab = "insert into ArtFab(nombre_art,nombre_fab,precio,IVA) values(?,?,?,?)";

        final String instSQLSelectFinal = "select * from ArtFab";


        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a la base de datos");

            Statement statement = connection.createStatement();


            // CREAMOS LA BD
            statement.executeUpdate(instSQLCrearBD);

            //SELECCIONAMOS LA BD
            statement.executeUpdate(instSQLUsarBD);

            System.out.println("Quieres crear la tabla Fabricantes y Articulos? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                statement.executeUpdate(instSQLCrearTabla1);
                System.out.println("La tabla Fabricantes ha sido creada exitosamente");
                statement.executeUpdate(instSQLCrearTabla2);
                System.out.println("La tabla Articulos ha sido creada exitosamente");

            } else {
                System.out.println("No se ha creado la tabla Fabricantes y Articulos");
            }

            //INSERTAMOS LOS DATOS EN LAS TABLA Fabricante

            System.out.println("Quieres ingresar datos en la tabla de fabricantes? (s/n)");
            String respuesta2 = scanner.nextLine();
            if (respuesta2.equalsIgnoreCase("s")) {
                statement.executeUpdate(instSQLInsertarFabricantes);
                System.out.println("Los datos han sido insertados exitosamente");
            } else {
                System.out.println("No se han insertado los datos");
            }

            //INSERTAMOS LOS DATOS EN LAS TABLA Articulos


            System.out.println("Quieres insertar datos en la tabla de articulos? (s/n)");
            String respuesta3 = scanner.nextLine();
            if (respuesta3.equalsIgnoreCase("s")) {
                statement.executeUpdate(instSQLInsertarArticulos);
                System.out.println("Los datos han sido insertados exitosamente");
            } else {
                System.out.println("No se han insertado los datos");
            }

            //CREAMOS LA TABLA ArtFab

            System.out.println("Quieres crear la tabla ArtFab? (s/n)");
            String respuesta4 = scanner.nextLine();
            if (respuesta4.equalsIgnoreCase("s")) {
                statement.executeUpdate(insSQLCrearTablaArtFab);
                System.out.println("La tabla ArtFab ha sido creada exitosamente");
            } else {
                System.out.println("No se ha creado la tabla ArtFab");
            }

            //INSERTAMOS LOS DATOS EN LA TABLA ArtFab sacando los datos de las otras tablas

            System.out.println("Quieres insertar los datos en la tabla ArtFab? (s/n)");
            String respuesta5 = scanner.nextLine();
            if (respuesta5.equalsIgnoreCase("s")) {

                ResultSet rs = statement.executeQuery(instSQLSelectJoin);

                while (rs.next()) {
                    String nombre_art = rs.getString("nombre_art");
                    String nombre_fab = rs.getString("nombre_fab");
                    int precio = rs.getInt("precio");
                    double IVA = calcularIVA(precio);


                    //INSERTAMOS LOS DATOS EN LA TABLA ArtFab

                    PreparedStatement ps = connection.prepareStatement(instSQLInsertarArtFab);
                    ps.setString(1, nombre_art);
                    ps.setString(2, nombre_fab);
                    ps.setInt(3, precio);
                    ps.setDouble(4, IVA);
                    ps.executeUpdate();
                }
                System.out.println("tabla rellenada correctamente");
            } else {
                System.out.println("No se han insertado los datos");
            }


// MOSTRAMOS LOS DATOS DE LA TABLA ARTFAB INSERTADOS ANTERIORMENTE
            System.out.println();
            System.out.println("RESULTADO FINAL DE LA TABLA ARTFAB: ");

            ResultSet rs = statement.executeQuery(instSQLSelectFinal);
            while (rs.next()) {
                String nombre_art = rs.getString("nombre_art");
                String nombre_fab = rs.getString("nombre_fab");
                int precio = rs.getInt("precio");
                double IVA = rs.getDouble("IVA");
                System.out.println("Articulo: " + nombre_art + ", Fabricante: " + nombre_fab + ", Precio: " + precio + ", IVA: " + IVA);
            }


            // Cerramos las conexiones
            statement.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

    }

    public static double calcularIVA(int precio) {

        if (precio < 200) {
            precio = precio * 10 / 100;

        } else if (precio < 500) {
            precio = precio * 8 / 100;
        } else if (precio < 700) {
            precio = precio * 6 / 100;
        }
        return precio;

    }

}
