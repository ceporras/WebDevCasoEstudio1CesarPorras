package meetingPlanner.CesarPorras.meetingPlanner.service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import meetingPlanner.CesarPorras.meetingPlanner.domain.Sala;
import org.springframework.stereotype.Service;

@Service
public class SalaService {
    
    public List<Sala> salaList = new ArrayList<>();
    
    //add sample items to list
    @PostConstruct //para que se ejecute 1 vez al iniciar
    public void addSamples(/*List<Sala> salaList*/){
        Sala sala1 = new Sala(1, "Sala 1", 5);
        Sala sala2 = new Sala(2, "Sala 2", 8);
        Sala sala3 = new Sala(3, "Sala 3", 2);
        Sala sala4 = new Sala(4, "Sala 4", 4);
        
        salaList.add(sala1);
        salaList.add(sala2);
        salaList.add(sala3);
        salaList.add(sala4);
        //return salaList;
    }
    
    
    public List<Sala> getSalas(){
        return salaList;
    }
    
    public Optional<Sala> getSala(long idSala){
        
        for (Sala sala : salaList){
            if(sala.getIdSala() == idSala){
                return Optional.of(sala);
            }
        }
        return Optional.empty();
    }
    
    public boolean save(Sala sala){
        for (Sala s : salaList){
            if (s.getIdSala()==sala.getIdSala()){//encuentro duplicado de ID
                return false;//nota que solo se agrega si el ID no es duplicado. 
                //no encontré como hacer para subir un mensaje de error hasta el UI 
            }
        }
        salaList.add(sala);
        return true;//no ecuentro duplicados de ID
    }
    
}
