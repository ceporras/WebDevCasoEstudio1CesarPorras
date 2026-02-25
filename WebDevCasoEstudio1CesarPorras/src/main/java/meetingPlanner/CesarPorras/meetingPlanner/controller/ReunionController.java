package meetingPlanner.CesarPorras.meetingPlanner.controller;

import jakarta.validation.Valid;
import meetingPlanner.CesarPorras.meetingPlanner.domain.Reunion;
import meetingPlanner.CesarPorras.meetingPlanner.service.ReunionService;
import meetingPlanner.CesarPorras.meetingPlanner.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Cesar Porras
 */
@Controller
@RequestMapping("/reunion")
public class ReunionController {

    @Autowired
    private ReunionService reunionService;
    @Autowired
    private SalaService salaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var reuniones = reunionService.getReuniones();
        model.addAttribute("reuniones", reuniones);
        model.addAttribute("reunion", new Reunion());
        model.addAttribute("totalReuniones", reuniones.size());
        var salas = salaService.getSalas();
        model.addAttribute("salas", salas);
        return "/reunion/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Reunion reunion) {


        Long idSala = reunion.getSala().getIdSala();
        reunionService.save(reunion, idSala);
        return "redirect:/reunion/listado";
    }
}
