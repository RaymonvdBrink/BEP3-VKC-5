package com.gerecht.gerecht.infrastructure.driver.web;

import com.gerecht.gerecht.core.application.GerechtService;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.infrastructure.driver.web.event.GerechtDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerecht")
public class GerechtController {


    private final GerechtService gerechtService;

    public GerechtController(GerechtService gerechtService) {
        this.gerechtService = gerechtService;
    }


    @GetMapping("/getAll")
    public List<Gerecht> geefGerechten(){

        return gerechtService.getAlleGerechten();
    }

    @PostMapping("/create")
    public Gerecht createGerecht(@RequestBody GerechtDTO gerechtDTO){
        Gerecht gerecht = new Gerecht(gerechtDTO.getNaam(), gerechtDTO.getBeschrijving(), gerechtDTO.getPrijs());
        gerechtService.createGerecht(gerecht);
        return gerecht;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGerecht(@PathVariable Long id){
        gerechtService.deleteGerecht(id);
    }
}
