package dds.airbn_ahk.entities.notificaciones;

import dds.airbn_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;
    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;
    @Column
    private Boolean leida;
    @Column(columnDefinition = "DATETIME")
    private LocalDate fechaLeida;

    public void marcarComoLeida() {
        this.leida = true;
        this.fechaLeida = LocalDate.now();
    }

    public Notificacion() {
        this.leida = false;
        this.fechaAlta = LocalDate.now();
    }
}
