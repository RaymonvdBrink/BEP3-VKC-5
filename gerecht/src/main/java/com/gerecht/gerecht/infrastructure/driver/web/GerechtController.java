package com.gerecht.gerecht.infrastructure.driver.web;

import com.gerecht.gerecht.core.application.GerechtCommandHandler;
import com.gerecht.gerecht.core.domain.Event.LijstGerechten;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.core.domain.Ingredient;
import com.gerecht.gerecht.infrastructure.driver.web.event.Besteldegerechten;
import com.gerecht.gerecht.infrastructure.driver.web.event.GerechtDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        List<Ingredient> list = new ArrayList();
        for(int i = 0;i<gerechtDTO.getIngredienten().size();i++){
            list.add(new Ingredient(gerechtDTO.getIngredienten().get(i).getNaam(), gerechtDTO.getIngredienten().get(i).getAantal()));
        }

        Gerecht gerecht = new Gerecht(gerechtDTO.getId(), gerechtDTO.getNaam(), gerechtDTO.getPrijs(), gerechtDTO.getAantal(), list);
        gerecht.setBeschikbaarheid(gerechtDTO.getbeschikbaarheid());



        gerechtService.createGerecht(gerecht);
        return gerecht;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGerecht(@PathVariable String id){
        gerechtService.deleteGerecht(id);
    }

    @GetMapping("/sendAll")
    public void stuurGerechten(){
        gerechtService.updateIngredienten(gerechtService.getAlleGerechten());

    }
    @GetMapping("/sendGerecht")
    public void stuurGerechtNaarBestelling(){
        List<Gerecht> gerechtLijst = new ArrayList<>();
//        gerechtLijst.add(new Gerecht("4","pizza",1.00,1));
//        gerechtLijst.add(new Gerecht("5","patat",2.00,1));
        LijstGerechten lijstGerechten = new LijstGerechten();
        lijstGerechten.setGerechten(gerechtLijst);
        gerechtService.StuurGerechtenNaarBestelling(lijstGerechten);
    }


    
}
