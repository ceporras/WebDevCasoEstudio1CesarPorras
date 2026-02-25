package meetingPlanner.CesarPorras.meetingPlanner.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Porras
 */
public class Sala {

    private long idSala;
    private String nombreSala;
    private int capacidad;
    //para almacenar las reuniones de la sala
    private List<Reunion> reuniones = new ArrayList<>(); 
    
    
    public Sala() {
    }

    public Sala(long idSala, String nombreSala, int capacidad) {
        this.idSala = idSala;
        this.nombreSala = nombreSala;
        this.capacidad = capacidad;
    }
    

    //aqui agrego una reunion a una sala
    public void addReunion(Reunion reunion){
        reuniones.add(reunion);
    }


    public long getIdSala() {
        return idSala;
    }

    public void setIdSala(long idSala) {
        this.idSala = idSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    public List<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(List<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

    
}
