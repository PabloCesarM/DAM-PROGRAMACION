package BD.ejemplos;

import java.sql.*;

public class TrabajandoPreparedStatement {

    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3306/pruebas";
        final String usuario = "root";
        final String contrasenia = "admin";
        final String instSQLverBDs = "SHOW DATABASES";

        try {
            Connection conexion  = DriverManager.getConnection(url,usuario, contrasenia);

            PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM productos  WHERE nombre=? AND importado=? ");

            //establecer interrogaciones    el 1 o el numero que se ponga hace referencia a la primera interrogacion o la que se haya puesto
            sentencia.setString(1,"taladradora");
            sentencia.setBoolean(2,false);
            //ejecutamos
            ResultSet rs = sentencia.executeQuery();

            //se recorre y se imprime
            while (rs.next()){
                System.out.println(rs.getInt("codigo") + "\t" + rs.getString("nombre") + "\t"
                + rs.getDouble("precio") + "\t" + rs.getBoolean("importado"));
            }



            System.out.println("-----");

            sentencia.setString(1,"destornillador");
            sentencia.setBoolean(2,true);

            rs = sentencia.executeQuery();

            while (rs.next()){
                System.out.println(rs.getInt("codigo") + "\t" + rs.getString("nombre") + "\t"
                        + rs.getDouble("precio") + "\t" + rs.getBoolean("importado"));
            }

            rs.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
