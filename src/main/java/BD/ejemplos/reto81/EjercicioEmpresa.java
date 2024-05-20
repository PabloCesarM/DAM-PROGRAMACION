package BD.ejemplos.reto81;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
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
    String url = "jdbc:mysql://localhost:3306/Empresa";
    String user = "root";
    String password = "admin";

    try (Connection conexion = DriverManager.getConnection(url, user, password);
         FileInputStream fis = new FileInputStream("datos.dat");
         DataInputStream dis = new DataInputStream(fis)) {

        while (dis.available() > 0) {
            char operation = dis.readChar();
            switch (operation) {
                case 'A':
                    altaEmp(dis, conexion);
                    break;
                case 'B':
                    bajaEmp(dis, conexion);
                    break;
                case 'M':
                    modificarSalario(dis, conexion);
                    break;
                default:
                    System.out.println("Unknown operation: " + operation);
            }
        }
        informe(conexion);
    } catch (SQLException | IOException e) {
        e.printStackTrace();
    }
}

    //metodo para dar de alta un empleado
    private static void altaEmp(DataInputStream dis, Connection connection) throws SQLException, IOException {
        int emp_no = dis.readInt();
        String apellido = dis.readUTF();
        String oficio = dis.readUTF();
        int dir = dis.readInt();
        String fecha_alt = dis.readUTF();
        float salario = dis.readFloat();
        float comision = dis.readFloat();
        int dept_no = dis.readInt();

        String sqlInsert = "INSERT INTO empleados VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(sqlInsert)) {
            pst.setInt(1, emp_no);
            pst.setString(2, apellido);
            pst.setString(3, oficio);
            pst.setInt(4, dir);
            pst.setDate(5, Date.valueOf(fecha_alt));
            pst.setFloat(6, salario);
            pst.setFloat(7, comision);
            pst.setInt(8, dept_no);
            pst.executeUpdate();
        }
    }

    //metodo para dar de baja un empleado
    private static void bajaEmp(DataInputStream dis, Connection connection) throws SQLException, IOException {
        int emp_no = dis.readInt();
        final String sqlEliminar = "DELETE FROM empleados WHERE emp_no = ?";

        try (PreparedStatement pst = connection.prepareStatement(sqlEliminar)) {
            pst.setInt(1, emp_no);
            pst.executeUpdate();
        }
    }

    //metodo para modificar el salario
    private static void modificarSalario(DataInputStream dis, Connection connection) throws SQLException, IOException {
        int emp_no = dis.readInt();
        float percentage = dis.readFloat();

        String sqlUpdate = "UPDATE empleados SET salario = salario + salario * ? / 100 WHERE emp_no = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sqlUpdate)) {
            pstmt.setFloat(1, percentage);
            pstmt.setInt(2, emp_no);
            pstmt.executeUpdate();
        }
    }

    //metodo para sacar un informe con los datos del empleado
    private static void informe(Connection connection) throws SQLException {
        String sqlSel = "SELECT empleados.emp_no, empleados.apellido, empleados.salario, departamentos.dnombre " +
                "FROM empleados " +
                "JOIN departamentos ON empleados.dept_no = departamentos.dept_no";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sqlSel)) {

            System.out.printf("%-10s %-15s %-10s %-20s%n", "Nº Empleado", "Nombre Empleado", "Salario", "Nombre Departamento");
            while (rs.next()) {
                int emp_no = rs.getInt("emp_no");
                String apellido = rs.getString("apellido");
                float salario = rs.getFloat("salario");
                String dnombre = rs.getString("dnombre");

                System.out.printf("%-10d %-15s %-10.2f %-20s%n", emp_no, apellido, salario, dnombre);
            }
        }
    }





}
