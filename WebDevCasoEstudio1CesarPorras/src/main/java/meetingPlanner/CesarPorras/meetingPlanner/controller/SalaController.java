package meetingPlanner.CesarPorras.meetingPlanner.controller;

import meetingPlanner.CesarPorras.meetingPlanner.domain.Sala;
import jakarta.validation.Valid;
import meetingPlanner.CesarPorras.meetingPlanner.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Cesar Porras
 */
@Controller
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var salas = salaService.getSalas();
        model.addAttribute("salas", salas);
        model.addAttribute("totalSalas", salas.size());
        return "/sala/listado";
    }

    
    @PostMapping("/guardar")
    public String guardar(@Valid Sala sala, RedirectAttributes redirectAttributes) {
        boolean doesIDExist = salaService.save(sala);
        
        if(!doesIDExist){
           // no logic to handle the refuse from service 
        }
        

        return "redirect:/sala/listado";
    }

}
