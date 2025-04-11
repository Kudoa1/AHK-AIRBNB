package dds.airbn_ahk.entities.usuarios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String nombre;
    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
}
