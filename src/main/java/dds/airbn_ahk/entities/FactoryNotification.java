package dds.airbn_ahk.entities;

public class FactoryNotification {
    private String crearMensaje(Reserva reserva) {
        String Mensaje = "";

        return switch (reserva.getEstadoReserva()) {
            case PENDIENTE -> "Tenes una reserva de " + reserva.getHuesped().getNombre()
                    + ", para el alojamiento " + reserva.getAlojamiento().getNombre()
                    + ", desde el dia " + reserva.getRangoFechas().getFechaInicio().toString()
                    + ", hasta el dia " + reserva.getRangoFechas().getFechaFin().toString()
                    + ".";
            case CONFIRMADA -> ", La reserva para el alojamiento " + reserva.getAlojamiento().getNombre()
                    + ", desde el dia " + reserva.getRangoFechas().getFechaInicio().toString()
                    + ", hasta el dia " + reserva.getRangoFechas().getFechaFin().toString()
                    + "fue confirmada";
            case CANCELADA -> ", La reserva para el alojamiento " + reserva.getAlojamiento().getNombre()
                    + ", desde el dia " + reserva.getRangoFechas().getFechaInicio().toString()
                    + ", hasta el dia " + reserva.getRangoFechas().getFechaFin().toString()
                    + "fue cancelada";
        };
    }

    public Notificacion crearSegunReserva(Reserva reserva) {
        Notificacion noti = new Notificacion();

        if (reserva.getEstadoReserva().equals(EstadoReserva.PENDIENTE)) {
            noti.setUsuario(reserva.getAlojamiento().getAnfitrion());
        } else if (reserva.getEstadoReserva().equals(EstadoReserva.CONFIRMADA)) {
            noti.setUsuario(reserva.getHuesped());
        } else if (reserva.getEstadoReserva().equals(EstadoReserva.CANCELADA)) {
            noti.setUsuario(reserva.getAlojamiento().getAnfitrion());
        }

        noti.setMensaje(this.crearMensaje(reserva));

        return null;
    }
}
