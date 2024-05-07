package BD.ejemplos;

import java.sql.*;

public class verBds {

    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String contrasenia = "admin";
        final String instSQLverBDs = "SHOW DATABASES";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(instSQLverBDs);
            //recorrer resultset
            while (rs.next()){
                System.out.println("Bd: " + rs.getString(1));
            }


            //crear base de datos nueva
        //    String consulta = "CREATE DATABASE BDnueva";
        //    st.executeUpdate(consulta);

            //conectarse a la base de datos para usarla
            st.executeUpdate("USE BDnueva");

            //crear una tabla
            st.executeUpdate("CREATE TABLE IF NOT EXISTS TABLANUEVA (ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NOMBRE VARCHAR (20))");




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
