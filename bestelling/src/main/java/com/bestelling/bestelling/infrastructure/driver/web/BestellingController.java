package com.bestelling.bestelling.infrastructure.driver.web;

import com.bestelling.bestelling.core.application.query.BestellingCommandHandler;
import com.bestelling.bestelling.core.application.query.BestellingQueryHandler;
import com.bestelling.bestelling.core.domain.*;
import com.bestelling.bestelling.infrastructure.driver.web.dto.BestellingDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bestelling")
public class BestellingController {
    private final BestellingQueryHandler serviceQuery;
    private final BestellingCommandHandler serviceCommand;
    public BestellingController(BestellingQueryHandler serviceQuery, BestellingCommandHandler serviceCommand) {
        this.serviceQuery = serviceQuery;
        this.serviceCommand = serviceCommand;
    }

    @GetMapping
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping("/test")
    public void testGet(){
        Adres adres = new Adres("Utrecht","teststraat","1" ,"1234AB");
        Klant klant = new Klant(UUID.randomUUID(), "bob", "last", adres);
        serviceCommand.saveKlant(klant);

        Klant test = serviceQuery.getKlantById(klant.getId());

        List<GerechtLijstItem> gerechtLijst = new ArrayList<>();
        gerechtLijst.add(new GerechtLijstItem(UUID.randomUUID(), "pizza", 1.00));
        gerechtLijst.add(new GerechtLijstItem(UUID.randomUUID(), "patta", 2.00));

        //serviceCommand.saveGerechtLijst(gerechtLijst);

        Gerecht gerecht = new Gerecht(UUID.randomUUID(), "pizza", 1.00, 1);
        List<Gerecht> gerechten = new ArrayList<>();
        gerechten.add(gerecht);
        gerechten.add(new Gerecht(UUID.randomUUID(), "patta", 2.00, 2));
        Bestelling Btest = new Bestelling(Status.INBEHANDELING, gerechten, klant.getAdres(), klant.getName());

        //serviceCommand.saveBestelling(Btest);


        //List<Bestelling> toreturn = serviceQuery.getAllBestelling();

        //return toreturn;

        serviceCommand.updateBesteldeGerechten(Btest);
    }

    @PostMapping
    public BestellingDTO newBesteling(@RequestBody BestellingDTO bestellingDTO){
        Klant klant = serviceQuery.getKlantById(bestellingDTO.getKlantId());

        ArrayList<Gerecht> gerechten = new ArrayList<>();
        bestellingDTO.getBestelingLijst().forEach((id, aantal) -> {
            GerechtLijstItem item = serviceQuery.getGerechtLijstItemById(id);
            Gerecht gerecht = new Gerecht(item.getId(), item.getNaam(), item.getPrice(), aantal);
            gerechten.add(gerecht);
        });

        Bestelling bestelling = new Bestelling(Status.INBEHANDELING, gerechten, klant.getAdres(), klant.getName());

        serviceCommand.saveBestelling(bestelling);
        serviceCommand.updateBesteldeGerechten(bestelling);

        return bestellingDTO;
    }
}
