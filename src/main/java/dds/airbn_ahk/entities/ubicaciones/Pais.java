package dds.airbn_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//para indicar que sea una entidad y tabla persistente en la BD
@Entity
@Table(name="pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //establezco como PK

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }
}
