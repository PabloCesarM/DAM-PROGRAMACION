package BD.ejemplos.reto81;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioCoches {
/* Sea la base de datos llamada DatosCoches, compuesta de dos tablas Propietarios y Coches y la cual se generará ejecutando el script Coches.sql.
Hacer un programa en java que cree la tabla SeguroCoche, cuya estructura es la siguiente:
Dni, Edad, Matricula y Seguro.
Los datos a insertar, se sacarán de las tablas anteriores, excepto el atributo Seguro que se calculará de acuerdo a las siguientes premisas:
el 2% del precio del coche para aquellos propietarios que tengan menos de 40 años
el 1% para el resto.
Posteriormente, se actualizara la tabla según el valor del seguro. Las condiciones son:
Si el seguro es menor de 100, éste se incrementará en un 5%
Si está comprendido entre 100 y 400, se quedará igual.
Si es mayor de 400 se dará de baja.
Finalmente, se escribirá en pantalla la tabla actualizada
 */
    public static void main(String[] args) {


        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatosCoches", "root", "admin");
            //crear el Statement para ejecutar sentencias sql directas
            Statement st = miConexion.createStatement();

            //crear la tabla SeguroCoche
            st.executeUpdate("CREATE TABLE SeguroCoche (Dni VARCHAR(5) Primary Key, Edad INTEGER, " +
                    "Matricula VARCHAR(10), Seguro DOUBLE)");

            //insertamos los datos en la tabla nueva los datos sacados de las otras dos
            st.executeUpdate("INSERT INTO SeguroCoche (Dni,Edad,Matricula) SELECT Dni,Propietarios.Edad,Coches.Matricula FROM Propietarios JOIN ");
/*tengo que cambiar la sentencia*/



        /*    "INSERT INTO SeguroCoche (Dni, Edad, Matricula, Seguro) " +
                    "SELECT p.Dni, p.Edad, c.Matricula, " +
                    "CASE WHEN p.Edad < 40 THEN c.Precio * 0.02 ELSE c.Precio * 0.01 END AS Seguro " +
                    "FROM Propietarios p JOIN Coches c ON p.Dni = c.DniPropietario";
        */
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


    private static double calcularSeguro(int edad, double precioCoche) {
        if (edad < 40) {
            return precioCoche * 0.02;
        } else {
            return precioCoche * 0.01;
        }
    }
}
