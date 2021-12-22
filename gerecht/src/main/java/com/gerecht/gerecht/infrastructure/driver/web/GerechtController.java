package com.gerecht.gerecht.infrastructure.driver.web;

import com.gerecht.gerecht.core.application.GerechtCommandHandler;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.infrastructure.driver.web.event.GerechtDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerecht")
public class GerechtController {


    private final GerechtCommandHandler gerechtService;

    public GerechtController(GerechtCommandHandler gerechtService) {
        this.gerechtService = gerechtService;
    }


    @GetMapping("/getAll")
    public List<Gerecht> geefGerechten(){
        return gerechtService.getAlleGerechten();

    }

    @PostMapping("/create")
    public Gerecht createGerecht(@RequestBody GerechtDTO gerechtDTO){
        Gerecht gerecht = new Gerecht(gerechtDTO.getId(), gerechtDTO.getNaam(), gerechtDTO.getPrijs(), gerechtDTO.getAantal());
        for(int i = 0;i<gerechtDTO.getIngredienten().size();i++){
            gerecht.voegIngredientToe(gerechtDTO.getIngredienten().get(i).getNaam(), gerechtDTO.getIngredienten().get(i).getAantal());
        }

        gerechtService.createGerecht(gerecht);
        return gerecht;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGerecht(@PathVariable Long id){
        gerechtService.deleteGerecht(id);
    }

    @GetMapping("/sendAll")
    public void stuurGerechten(){
        gerechtService.stuurAlleGerechten();
    }
}
