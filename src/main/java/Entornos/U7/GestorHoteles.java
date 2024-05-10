package Entornos.U7;

import java.util.List;

public class GestorHoteles {
    private Usuario usuario;

    public GestorHoteles(Usuario usuario) {
        this.usuario = usuario;
    }

    public void solicitarReserva(Reserva reserva) {

    }
/*
    public List<Reserva> visualizarReservas() {
        return usuario.getClientes().get().getReservas();
    }*/

    public List<Reserva> visualizarReservasSinFactura() {

        return null;
    }

    public List<Reserva> visualizarReservasSinFacturaHoy() {

        return null;
    }
}
