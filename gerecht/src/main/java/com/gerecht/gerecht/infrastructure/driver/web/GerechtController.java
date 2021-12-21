package com.gerecht.gerecht.infrastructure.driver.web;

import com.gerecht.gerecht.core.application.GerechtCommandHandler;
import com.gerecht.gerecht.core.application.GerechtQueryHandler;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.infrastructure.driver.web.event.GerechtDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerecht")
public class GerechtController {

    private final GerechtQueryHandler gerechtQueryHandler;
    private final GerechtCommandHandler gerechtService;

    public GerechtController(GerechtQueryHandler gerechtQueryHandler, GerechtCommandHandler gerechtService) {
        this.gerechtQueryHandler = gerechtQueryHandler;
        this.gerechtService = gerechtService;
    }


    @GetMapping("/getAll")
    public List<Gerecht> geefGerechten() {

        return gerechtService.getAlleGerechten();
    }

    @PostMapping("/create")
    public Gerecht createGerecht(@RequestBody GerechtDTO gerechtDTO) {
        Gerecht gerecht = new Gerecht(gerechtDTO.getNaam(), gerechtDTO.getBeschrijving(), gerechtDTO.getPrijs());
        gerechtService.createGerecht(gerecht);
        return gerecht;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGerecht(@PathVariable Long id) {
        gerechtService.deleteGerecht(id);
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody String bericht) {
        GerechtQueryHandler.sendMessage(bericht);

    }
}
