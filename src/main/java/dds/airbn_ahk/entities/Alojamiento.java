package dds.airbn_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Alojamiento {
    @Getter
    @Setter
    private Usuario anfitrion;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private Double precioPorNoche;
    @Getter
    @Setter
    private Moneda moneda;
    @Getter
    @Setter
    private LocalTime horarioCheckin;
    @Getter
    @Setter
    private LocalTime horarioCheckOut;
    @Getter
    @Setter
    private Direccion direccion;
    @Getter
    @Setter
    private Integer cantHuespedesMax;

    @Getter
    private List<Caracteristica> caracteristicas;
    @Getter
    private List<Reserva> reservas;
    @Getter
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




