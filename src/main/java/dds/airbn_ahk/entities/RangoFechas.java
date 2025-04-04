package dds.airbn_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RangoFechas {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(RangoFechas rango) {
        return this.fechaInicio.isBefore(rango.getFechaFin())
                && this.getFechaInicio().isBefore(this.fechaFin);
    }
}
