package Entornos.U7;

public class Usuario {
    private String nombre;
    private String contraseña;

    // Constructor
    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    // getters/setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public ThreadLocal<Object> getClientes() {
        return null;
    }
}
