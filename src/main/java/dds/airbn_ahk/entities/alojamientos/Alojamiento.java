package dds.airbn_ahk.entities.alojamientos;

import dds.airbn_ahk.entities.ubicaciones.Direccion;
import dds.airbn_ahk.entities.Moneda;
import dds.airbn_ahk.entities.reservas.RangoFechas;
import dds.airbn_ahk.entities.reservas.Reserva;
import dds.airbn_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "alojamiento")
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "anfitrion_id",nullable = false)
    private Usuario anfitrion;

    @Getter
    @Setter
    @Column
    private String nombre;

    @Getter
    @Setter
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Getter
    @Setter
    @Column
    private Double precioPorNoche;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Moneda moneda;

    @Getter
    @Setter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckin;

    @Getter
    @Setter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckOut;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "direccion_id",nullable = false)
    private Direccion direccion;

    @Getter
    @Setter
    @Column
    private Integer cantHuespedesMax;


    @Getter
    @ElementCollection
    @CollectionTable(name = "alojamiento_caracateristica", joinColumns = @JoinColumn(name = "alojamiento_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "caracteristica")
    private List<Caracteristica> caracteristicas;

    @Getter
    //si la relacion en bidireccional (ambas se reconocen), se coloca mappedBy y el nombre del atributo en la otra clase
    @OneToMany(mappedBy = "alojamiento")
    private List<Reserva> reservas;

    @Getter
    @OneToMany
    @JoinColumn(name = "alojamiento_id")
    private List<Foto> fotos;


    //constructor
    public Alojamiento() {
        this.fotos = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Boolean estasDisponibleEn(RangoFechas rango) {
        //para que esté libre tiene que ser x1<=x4 && x3<=x2

        //Forma 1:
//        boolean haySuperposicion = false;
//        int i = 0;
//
//        //recorremos el array de reservas y que cuando encuentre, se detenga
//        while (i < this.reservas.size() && !haySuperposicion) {
//            Reserva reserva = this.reservas.get(i); //para obtener el objeto reserva actual
//            RangoFechas rangoDeLaReserva = reserva.getRangoFechas(); //para tener el rango de la NUEVA
//            if (rangoDeLaReserva.haySuperposicionCon(rango)) {
//                haySuperposicion = true;
//            }
//            i++;
//        }
//        return !haySuperposicion;

        //Forma 2:
        return this.reservas.stream().noneMatch(r -> r.getRangoFechas().haySuperposicionCon(rango));
    }

    public Boolean tenesCaracteristica(Caracteristica caracteristica) {
        return this.caracteristicas.contains(caracteristica);
    }

    public Boolean puedenAlojarse(Integer cantHuespedes) {
        return this.cantHuespedesMax <= cantHuespedes;
    }

    public Boolean tuPrecioEstaDentroDe(Double valorMin, Double valorMax) {
        return this.precioPorNoche <= valorMax && this.precioPorNoche >= valorMin;
    }

}




