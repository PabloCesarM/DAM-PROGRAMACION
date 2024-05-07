package BD.ejemplos;



import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ejemplo1 {

    public static void main(String[] args) {
        final String instSQLSelect="select * from productos";
        final String instSQLInsert="INSERT into productos values (4,'pistola',500.99,true)";
        final String instSQLDelete="delete from productos where codigo=4";
        final String instSQLUpdate="update productos set precio = precio * 2 where codigo=2";
        try {
            //Class.forName("com.mysql.jbdc.driver");
            //Connection miConexion = DriverManager.getConnection("jbdc:mysql://localhost:3307/sakila","root","admin");
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "admin");
            Statement st = miConexion.createStatement();
            //st.executeUpdate(instSQLInsert);
            //st.executeUpdate(instSQLDelete);
            st.execute(instSQLUpdate);
            ResultSet rs =st.executeQuery(instSQLSelect);

            while (rs.next()){



                System.out.println(rs.getInt("codigo")+
                        "\t"+rs.getString("nombre")
                        +"\t"+rs.getDouble("precio")
                        +"\t"+ rs.getBoolean("importado"));

                //System.out.println(rs.getInt("id_cuenta")+"\t"+rs.getDouble("saldo"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}