package BD.ejemplos.reto81;

import java.sql.*;

public class EjercicioAmerica {
    /*Se tiene la base de datos América, compuesta por las tablas Personas y Países.
    Hacer un programa en Java que cree la tabla PersonasPaises que tendrá los siguientes atributos:
    Id, Nombre, Apellido, Edad, NombrePais y Tamaño.
    La información que va almacenar es la sacada de las otras dos tablas. Tras crear dicha tabla, actualizarla
    sumando 1 a la edad de las personas de Costa Rica.
    Finalmente sacar un listado con toda la información de la nueva tabla. */

    public static void main(String[] args) {

        final String instSQLSelect = "select * from personaspaises";

        Connection miConexion = null;

        try {
            //creamos la conexion       //si no se pone "america" luego habria que hacer un use para elegir la base de datos que queremos utilizar
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/america", "root", "admin");
            //crear el Statement para ejecutar sentencias sql directas
            Statement st = miConexion.createStatement();


            // st.executeUpdate("CREATE TABLE PersonasPaises (Id INT PRIMARY KEY, Nombre VARCHAR(15), " +
            //        "Apellido VARCHAR(15), Edad TINYINT, NombrePais VARCHAR(15), Tamaño VARCHAR(15))");

            // cuando se hace un select dentro de un insert no se tiene que poner el values
      /*      st.executeUpdate("INSERT INTO PersonasPaises(id,nombre,apellido,edad,nombrepais,tamaño) SELECT Persona.Id, " +
                    "Persona.Nombre, Persona.Apellido, Persona.Edad, Pais.Nombre, Pais.Tamaño FROM Persona JOIN Pais " +
                    "ON Persona.Pais = Pais.Id");
        */

            //actualizar los datos de la tabla sumando 1 a la edad en las personas de chile
        /*            st.executeUpdate("UPDATE PersonasPaises SET Edad = Edad + 1 WHERE NombrePais = 'Costa Rica'");
        */
            //mostar los datos de la tabla PersonasPaises
                //se crea la query arriba
            st.execute(instSQLSelect);
                //se declara el resulset obtener el contenido
            ResultSet rs = st.executeQuery(instSQLSelect);
                //se utiliza el while para recorrer la tabla e ir imprimiendo los datos
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("Nombre") + "\t" +
                        rs.getString("apellido") + "\t" + rs.getInt("edad") + "\t" +
                        rs.getString("NombrePais") + "\t" + rs.getString("tamaño"));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
