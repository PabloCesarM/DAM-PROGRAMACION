package BD.ejemplos.reto81;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioAmerica {
    /*Se tiene la base de datos América, compuesta por las tablas Personas y Países.
    Hacer un programa en Java que cree la tabla PersonasPaises que tendrá los siguientes atributos:
    Id, Nombre, Apellido, Edad, NombrePais y Tamaño.
    La información que va almacenar es la sacada de las otras dos tablas. Tras crear dicha tabla, actualizarla
    sumando 1 a la edad de las personas de Costa Rica.
    Finalmente sacar un listado con toda la información de la nueva tabla.     */

    public static void main(String[] args) {

        Connection miConexion = null;

        try {
            //creamos la conexion
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/america", "root", "admin");
            //crear el Statement para ejecutar sentencias sql directas
            Statement st = miConexion.createStatement();

            st.executeUpdate("CREATE TABLE PersonasPaises (Id INT PRIMARY KEY, Nombre VARCHAR(15), " +
                    "Apellido VARCHAR(15), Edad TINYINT, NombrePais VARCHAR(15), Tamaño VARCHAR(15))");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
