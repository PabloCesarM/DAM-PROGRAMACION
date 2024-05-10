package Entornos.U7;

import java.util.List;

public class Cliente extends Usuario {
    private List<Reserva> reservas;

    // Constructor
    public Cliente(String nombre, String contraseña) {
        super(nombre, contraseña);
    }

    //getters/setters

    public List<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
