package dds.airbn_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Reserva {
    private LocalDate fechaAlta;
    private Usuario huesped;
    private Alojamiento alojamiento;
    private RangoFechas rangoFechas;
    private EstadoReserva estadoReserva;
    private Double precioPorNoche;

    public void actualizarEstado(EstadoReserva estado) {
        this.estadoReserva = estado;
        //TODO pendiente de ser guardado
        Notificacion notificacion= new FactoryNotification().crearSegunReserva(this);
    }
}
