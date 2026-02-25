package meetingPlanner.CesarPorras.meetingPlanner.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import meetingPlanner.CesarPorras.meetingPlanner.domain.Reunion;
import meetingPlanner.CesarPorras.meetingPlanner.domain.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Cesar Porras
 */
@Service
public class ReunionService {

    @Autowired
    private SalaService salaService;
    public List<Reunion> reunionList = new ArrayList<>();

    public List<Reunion> getReuniones() {
        return reunionList;
    }


    public boolean save(Reunion reunion, Long idSala) {
        for (Reunion r : reunionList) {
            if (r.getIdReunion() == reunion.getIdReunion()) {//encuentro duplicado de ID
                return false;//solo NO se guarda, no se muestra en UI el error
            }
        }
        Optional<Sala> optSala = salaService.getSala(idSala);

        if (optSala.isEmpty()) {
            //no se encuentra la sala a la que asociar la reunion
            return false;
        }
        
        Sala sala = optSala.get();
                
        reunion.setSala(sala);
        System.out.println(reunion.getSala().getNombreSala());
        sala.getReuniones().add(reunion);
        
        reunionList.add(reunion);
        return true;//no ecuentro duplicados de ID

    }

}
