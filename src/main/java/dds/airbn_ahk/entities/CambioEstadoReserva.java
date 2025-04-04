package dds.airbn_ahk.entities;

import java.time.LocalDate;

public class CambioEstadoReserva {
    private LocalDate fecha;
    private EstadoReserva estado;
    private Reserva reserva;
    private String motivo;
    private Usuario usuario;
}
