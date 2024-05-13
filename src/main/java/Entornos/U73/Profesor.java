package Entornos.U73;

public class Profesor {
    private String nombreUsuario;
    private String contrasenia;

    //contructor
    public Profesor(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = "p" + nombreUsuario;
        this.contrasenia = contrasenia;
    }

    //getter/setter
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = "a" + nombreUsuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    //método para poner/modificar notas



    //método para listar todas las notas


}
