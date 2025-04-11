package dds.airbn_ahk.entities.reservas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class RangoFechas {
    @Column(columnDefinition = "DATE")
    private LocalDate fechaInicio;
    @Column(columnDefinition = "DATE")
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(RangoFechas rango) {
        return this.fechaInicio.isBefore(rango.getFechaFin())
                && this.getFechaInicio().isBefore(this.fechaFin);
    }
}
