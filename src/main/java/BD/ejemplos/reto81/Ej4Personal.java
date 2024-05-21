package BD.ejemplos.reto81;

import java.sql.*;
import java.util.Scanner;

public class Ej4Personal {
    /*
    Sea la base de datos llamada Personal, compuesta de dos tablas Empleado y Departamento las cuales se generarán ejecutando el script personal.sql
Hacer un programa en java que cree la tabla OficinaEmpleados, cuya estructura es la siguiente:
Nombre Empleado, Nombre Departamento, Salario y Comisión.
Los datos a insertar, se sacarán de las tablas anteriores, excepto el atributo Comisión que se calculará de acuerdo al departamento al que pertenezca:
Si pertenece a 'Contabilidad', será el 10% del salario.
Si pertenece a 'Investigación', será el 20% del salario.
Si pertenece a 'Ventas', será el 5% del salario.
Si pertenece a 'Producción', será el 15% del salario.
Posteriormente, se actualizara la tabla según la comisión. Las condiciones son:

Si la comisión es menor de 300, este se incrementará en un 10%
Si está comprendida entre 400 y 600, se incrementará en un 5%
Si es mayor de 600 se quedará igual.
Finalmente, se escribirá en pantalla la tabla actualizada
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creamos la variable para la url
        final String url = "jdbc:mysql://localhost:3306/Personal";
        //creamos la variable para el usuario
        final String usuario = "root";
        //creamos la variable para la contrasenia
        final String contrasenia = "admin";
        //creamos la variable para la sentencia sql
        final String instSQLSelect = null;
        final String sqlCrearTabla = "CREATE TABLE OficinasEmpleados (ID INT AUTO_INCREMENT PRIMARY KEY, NombreEmpleado " +
                "VARCHAR(20), NombreDepartamento VARCHAR(20), Salario INT, Comision DOUBLE)";
        final String sqlSelcJoin = "SELECT empleado.Nombre as nombreEmpleado,departamento.nombre as nombreDepartamento,empleado.salario FROM empleado join " +
                "departamento ON empleado.dept_no = departamento.dept_no";
        final String sqlInsOE ="INSERT INTO OficinasEmpleados (NombreEmpleado," +
                " NombreDepartamento, Salario, Comision) VALUES (?, ?, ?, ?)";
        final String sqlUpdateMenorCom300= "UPDATE OficinasEmpleados SET comision = comision*1.1 WHERE comision <300";
        final String sqlUpdateEntre400y600= "UPDATE OficinasEmpleados SET comision = comision*1.05 WHERE comision >= 400 and comision <= 600";


        //creamos la conexion
        Connection miConexion = null;
        try {
            //utilizar la conexion paraconectar con la bd Personal
            // si no se pone "america" luego habria que hacer un use para elegir la base de datos que queremos utilizar
            miConexion = DriverManager.getConnection(url, usuario, contrasenia);
            //crear el Statement para ejecutar sentencias sql directas
            Statement st = miConexion.createStatement();

            //crear la tabla OficinasEmpleados
            System.out.println("Quieres crear la tabla OficinasEmpleados: (s/n)");
            String crear = sc.nextLine();
            if (crear.equalsIgnoreCase("s")) {
                st.executeUpdate(sqlCrearTabla);
            }

            //para obtener los campos e insertar
            System.out.println("Quieres crear la tabla OficinasEmpleados: (s/n)");
            ResultSet rs = st.executeQuery(sqlSelcJoin);
            while (rs.next()) {
                String nombreEmpleado = rs.getString("nombreEmpleado");
                String nombreDepartamento = rs.getString("nombreDepartamento");
                int salario = rs.getInt("salario");
                //calcular la comision
                double comision= calcularComision(salario, nombreDepartamento);
                //segun se va sacando se va insertando uno a uno
                PreparedStatement pst = miConexion.prepareStatement(sqlInsOE);
                pst.setString(1, nombreEmpleado);
                pst.setString(2, nombreDepartamento);
                pst.setInt(3, salario);
                pst.setDouble(4, comision);
                pst.executeUpdate();
            }

            //actualizar la comision segun parametros
            st.executeUpdate(sqlUpdateMenorCom300);
            st.executeUpdate(sqlUpdateEntre400y600);

            //mostrar la tabla actualizada
            rs = st.executeQuery("SELECT * FROM OficinasEmpleados");
            while (rs.next()) {
                System.out.println(rs.getString("nombreEmpleado") + "\t" + rs.getString("nombreDepartamento")
                        + "\t" + rs.getInt("salario") + "\t" + rs.getDouble("comision"));
            }

            //cerrar
            rs.close();
            st.close();
            miConexion.close();

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //metodo para sacar la comision
    public static double calcularComision(int salario, String nombreDepartamento){
        double comision = 0;
        if(nombreDepartamento.equalsIgnoreCase("Contabilidad")){
            comision = salario*0.1;
        }
        else if (nombreDepartamento.equalsIgnoreCase("Investigacion")){
            comision = salario*0.2;
        }
        else if (nombreDepartamento.equalsIgnoreCase("Ventas")){
            comision = salario*0.05;
        }
        else if (nombreDepartamento.equalsIgnoreCase("Produccion")){
            comision = salario*0.15;
        }
        return comision;
    }

}
