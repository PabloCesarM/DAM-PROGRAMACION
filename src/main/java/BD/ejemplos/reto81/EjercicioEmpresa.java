package BD.ejemplos.reto81;

import java.sql.*;

public class EjercicioEmpresa {
/*
Ejecutar el fichero empresa.sql, que creará la base de datos Empresa, compuesta de las tablas Empleados y Departamentos. Hacer un programa que actualice la tabla Empleados, mediante el fichero binario datos.dat.
El fichero, datos.dat, tiene la siguiente estructura:
El primer campo es una cadena que contendrá una A, una B o una M (alta, baja o modificación) y dependiendo de la operación tendrá los siguientes campos.
Si es una baja sólo aparecerá el código del empleado a dar de baja.
Si es un alta, vendrán todos los datos que forman parte de la tabla Empleados que es donde se van a insertar los datos.
Y si es una modificación, vendrá el código del empleado y el porcentaje que se subirá el salario.
Finalmente, sacar un informe en el que aparezca:
Nº Empleado Nombre Empleado Salario Nombre Departamento
 */
    public static void main(String[] args) {

        final String instSQLSelect = "select * from personaspaises";

        Connection miConexion = null;

        try {
            //creamos la conexion       //si no se pone "empresaProgramacion" luego habria que hacer un use para elegir la base de datos que queremos utilizar
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresaProgramacion", "root", "admin");
            //crear el Statement para ejecutar sentencias sql directas
            Statement st = miConexion.createStatement();


            // st.executeUpdate("CREATE TABLE Empleados (Id INT PRIMARY KEY, Nombre VARCHAR(15), " +
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
