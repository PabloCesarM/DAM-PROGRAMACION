package BD.ejemplos;

import java.sql.*;

public class ExBDconProg {

    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String contrasenia = "admin";


        try {
            //CREAR CONEXION CON LA BASE DE DATOS
            Connection conexion  = DriverManager.getConnection(url,usuario, contrasenia);
            Statement st = conexion.createStatement();

            //CREAR BASE DE DATOS
            Statement stCREARBD = conexion.createStatement();
            stCREARBD.executeUpdate("CREATE DATABASE IF NOT EXISTS tiendaProg");
            stCREARBD.close();

            //usar la base de datos, se deja activo porque en el string creado de url
            //no se pone el nombre de la base de datos
            st.executeUpdate("USE tiendaProg");

            //crear tabla
            Statement stCREARTF = conexion.createStatement();
            stCREARTF.executeUpdate("create table Fabricantes(\n" +
                    "  CLFAB int Primary Key,\n" +
                    "  Nombre varchar(30)\n" +
                    ")ENGINE=InnoDB;");
            stCREARTF.close();
            Statement stCREARTa = conexion.createStatement();
            stCREARTa.executeUpdate("create table Articulos(\n" +
                    "  CLART int Primary Key,\n" +
                    "  Nombre varchar(30),\n" +
                    "  Precio int,\n" +
                    "  CLFAB int,\n" +
                    "  Foreign Key (CLFAB) References Fabricantes(CLFAB)\n" +
                    "  ON DELETE CASCADE ON UPDATE CASCADE\n" +
                    ")ENGINE=InnoDB;");
            stCREARTa.close();


            //insertar los datos en las tabla fabricantes
            Statement sti1 = conexion.createStatement();
            sti1.executeUpdate("insert into Fabricantes values(1,'Kingston');");
            sti1.close();
            Statement sti2 = conexion.createStatement();
            sti2.executeUpdate("insert into Fabricantes values(2,'Adata');");
            sti2.close();
            Statement sti3 = conexion.createStatement();
            sti3.executeUpdate("insert into Fabricantes values(3,'Logitech');");
            sti3.close();
            Statement sti4 = conexion.createStatement();
            sti4.executeUpdate("insert into Fabricantes values(4,'Lexar');");
            sti4.close();
            Statement sti5 = conexion.createStatement();
            sti5.executeUpdate("insert into Fabricantes values(5,'Seagate');");
            sti5.close();

            //insertar los datos en las tabla articulos
            Statement stiArt1 = conexion.createStatement();
            stiArt1.executeUpdate("insert into Articulos values(1,'Teclado',100,3);");
            stiArt1.close();
            Statement stiArt2 = conexion.createStatement();
            stiArt2.executeUpdate("insert into Articulos values(2,'Disco Duro 300Gb',500,5);");
            stiArt2.close();
            Statement stiArt3 = conexion.createStatement();
            stiArt3.executeUpdate("insert into Articulos values(3,'Mouse',80,3);");
            stiArt3.close();
            Statement stiArt4 = conexion.createStatement();
            stiArt4.executeUpdate("insert into Articulos values(4,'Memoria USB',140,4);");
            stiArt4.close();
            Statement stiArt5 = conexion.createStatement();
            stiArt5.executeUpdate("insert into Articulos values(5,'Memoria Ram',290,1);");
            stiArt5.close();
            Statement stiArt6 = conexion.createStatement();
            stiArt6.executeUpdate("insert into Articulos values(6,'Disco Duro Extraible 250 Gb',650,5);");
            stiArt6.close();
            Statement stiArt7 = conexion.createStatement();
            stiArt7.executeUpdate("insert into Articulos values(7,'Memoria USB',279,1);");
            stiArt7.close();
            Statement stiArt8 = conexion.createStatement();
            stiArt8.executeUpdate("insert into Articulos values(8,'DVD Rom',450,2);");
            stiArt8.close();
            Statement stiArt9 = conexion.createStatement();
            stiArt9.executeUpdate("insert into Articulos values(9,'CD Rom',200,2);");
            stiArt9.close();
            Statement stiArt10 = conexion.createStatement();
            stiArt10.executeUpdate("insert into Articulos values(10,'Tarjeta de Red',180,3);");
            stiArt10.close();

            //crear tabla ArtFab
            Statement stCrearArt = conexion.createStatement();
            stCrearArt.executeUpdate("create table ArtFab(\n" +
                    "  NombreArticulo varchar(30) ,\n" +
                    "  NombreFabricante varchar(30),\n" +
                    "  Precio int,\n" +
                    "  IVA int\n" +
                    ")ENGINE=InnoDB;");
            stCrearArt.close();

            //insetar datos en ArtFab desde las otras dos tablas
//            Statement stInsertArt = conexion.createStatement();
//            stInsertArt.executeUpdate("INSERT INTO ArtFab(NombreArticulo,NombreFabricante,Precio) SELECT " +
//                    "articulos.nombre, fabricantes.Nombre, articulos.precio " +
//                    "FROM articulos JOIN fabricantes ON articulos.CLFAB = fabricantes.CLFAB");
//            stInsertArt.close();
            //NO HE PODIDO AÑADIR EL IVA
//            //insert para añadir el IVA
//            Statement stInsertArtIVA = conexion.createStatement();
//            stInsertArtIVA.executeUpdate("INSERT INTO ArtFab(IVA) SELECT " +
//                    " articulos.precio " +
//                    "FROM articulos JOIN fabricantes ON articulos.CLFAB = fabricantes.CLFAB");
//            stInsertArt.close();

            //como se tendria que haber hecho

            String join ="select articulos.nombre as art_nombre,fabricantes.nombre as fab_nombre , articulos.nombre from articulos join fabricantes ON articulos.CLFAB = fabricantes.CLFAB";
            String insertUltimo= "insert into ArtFab (NombreArticulo,NombreFabricante,precio,IVA) values (?,?,?,?)";

            Statement stjoin =conexion.createStatement();
            ResultSet  rs = stjoin.executeQuery(join);
       while (rs.next()){

           String art_nombre=rs.getString(1);
           String fab_nombre = rs.getString(2);
           int precio = rs.getInt(3);
           int IVA = (int) calcularIVA(precio);

           PreparedStatement ps = conexion.prepareStatement(insertUltimo);
            ps.setString(1,art_nombre);
            ps.setString(2,fab_nombre);
            ps.setInt(3,precio);
            ps.setInt(4,IVA);
            ps.executeUpdate();




       }







            //recorrer la tabla artfab para mostrar su contenido
            Statement stImprimir = conexion.createStatement();
              rs = stImprimir.executeQuery("select * from artfab");
            while (rs.next()) {
                System.out.println(rs.getString("NombreArticulo") + " " + rs.getString("NombreFabricante") +
                            " " + rs.getInt("Precio") + " " + rs.getDouble("IVA"));
            }

            rs.close();
            stImprimir.close();
            //cerrar el statment para el use
            st.close();
            //cerrar la conexion
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static double calcularIVA(double precio){
        if (precio<200){
            precio = precio*0.1;
        }else if (precio<500){
            precio = precio*0.08;
        }else if (precio<700){
            precio = precio*0.08;
        }

        return precio;
    }

}