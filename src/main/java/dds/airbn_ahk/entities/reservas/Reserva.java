package dds.airbn_ahk.entities.reservas;

import dds.airbn_ahk.entities.alojamientos.Alojamiento;
import dds.airbn_ahk.entities.notificaciones.FactoryNotification;
import dds.airbn_ahk.entities.notificaciones.Notificacion;
import dds.airbn_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;
    @ManyToOne
    @JoinColumn(name = "huesped_id",nullable = false)
    private Usuario huesped;
    @ManyToOne
    @JoinColumn(name = "alojamiento_id",nullable = false)
    private Alojamiento alojamiento;
    @Embedded //los atributos de la clase embebida (PREVIAMENTE CONFIGURADOS COMO COLUMNAS), los ponemos como columnas en esta
    private RangoFechas rangoFechas;
    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;
    @Column
    private Double precioPorNoche;

    public void actualizarEstado(EstadoReserva estado) {
        this.estadoReserva = estado;
        //TODO pendiente de ser guardado
        Notificacion notificacion= new FactoryNotification().crearSegunReserva(this);
    }
}
