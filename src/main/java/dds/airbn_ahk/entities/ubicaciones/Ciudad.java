package dds.airbn_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //establezco como PK
    @Column(name = "nombre", nullable = false)
    private String nombre;

//    @Transient  //indica que ese atributo cuando lo hereda, no lo persista
    @ManyToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id", nullable = false)
    private Pais pais;
}
