package com.bestelling.bestelling;

import com.bestelling.bestelling.core.application.query.BestellingCommandHandler;
import com.bestelling.bestelling.core.application.query.BestellingQueryHandler;
import com.bestelling.bestelling.core.domain.Adres;
import com.bestelling.bestelling.core.domain.GerechtLijstItem;
import com.bestelling.bestelling.core.domain.Klant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class SetupTestData {
    private final BestellingQueryHandler serviceQuery;
    private final BestellingCommandHandler serviceCommand;
    public SetupTestData(BestellingQueryHandler serviceQuery, BestellingCommandHandler serviceCommand) {
        this.serviceQuery = serviceQuery;
        this.serviceCommand = serviceCommand;

        Adres adres1 = new Adres("Utrecht", "teststraat", "1", "1234AB");
        Adres adres2 = new Adres("Utrecht", "teststraat", "2", "1235AB");
        Adres adres3 = new Adres("Utrecht", "teststraat", "3", "1236AB");

        Klant klant1 = new Klant(UUID.randomUUID(), "Bob", "test", adres1);
        Klant klant2 = new Klant(UUID.randomUUID(), "Jef", "test", adres2);
        Klant klant3 = new Klant(UUID.randomUUID(), "May", "test", adres3);

        if(serviceQuery.getAllKlant().size() == 0){
            serviceCommand.saveKlant(klant1);
            serviceCommand.saveKlant(klant2);
            serviceCommand.saveKlant(klant3);
        }

        GerechtLijstItem item1 = new GerechtLijstItem(UUID.randomUUID(), "Pizza", 2.00);
        GerechtLijstItem item2 = new GerechtLijstItem(UUID.randomUUID(), "Pattat", 1.00);
        GerechtLijstItem item3 = new GerechtLijstItem(UUID.randomUUID(), "Ijs", 0.50);
        List<GerechtLijstItem> lijstItems = new ArrayList<>();
        lijstItems.add(item1);
        lijstItems.add(item2);
        lijstItems.add(item3);

        if(serviceQuery.getAllItems().size() == 0){
            serviceCommand.saveGerechtLijst(lijstItems);
        }
    }


}