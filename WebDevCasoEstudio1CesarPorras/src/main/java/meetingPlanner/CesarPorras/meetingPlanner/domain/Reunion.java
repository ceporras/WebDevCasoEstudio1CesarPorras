package meetingPlanner.CesarPorras.meetingPlanner.domain;

import java.time.LocalDate;

/**
 *
 * @author Cesar Porras
 */
public class Reunion {
    
    private long idReunion;
    private String tituloReunion;
    private LocalDate fecha;
    private String hora;
    private Sala sala = new Sala(); //sala a la que se asocia la reunion

    public Reunion() {
    }

    public Reunion(long idReunion, String tituloReunion, LocalDate fecha, String hora, Sala Sala) {
        this.idReunion = idReunion;
        this.tituloReunion = tituloReunion;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = new Sala();
    }

    

    public long getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(long idReunion) {
        this.idReunion = idReunion;
    }

    public String getTituloReunion() {
        return tituloReunion;
    }

    public void setTituloReunion(String tituloReunion) {
        this.tituloReunion = tituloReunion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }


    
    
}
