package com.voorraad.voorraad.infrastructure.driver.web.event;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.voorraad.voorraad.core.application.VoorraadCommandHandler;
import com.voorraad.voorraad.core.domain.Ingredient;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechten;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechtenDTO;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtDTO;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RabbitMqEventListener {
    private final VoorraadCommandHandler commandHandler;
    private final VoorraadCommandHandler serviceCommand;

    public RabbitMqEventListener(VoorraadCommandHandler commandHandler, VoorraadCommandHandler serviceCommand) {
        this.commandHandler = commandHandler;
        this.serviceCommand = serviceCommand;
    }

    //    @RabbitListener(queues = {"gerecht-keywords"})
//    void listen(Gerecht gerecht) {
//        Gerecht gerecht1 = new Gerecht();
//        serviceCommand.createVoorraaad(gerecht1);
//    }
    @RabbitListener(queues = {"gerecht-keywords"})
    void listen(AlleGerechtenDTO event) {
        System.out.println("listener: " + event);
        List<Ingredient> ingredienten = new ArrayList<>();
        List<Gerecht> gerechten = new ArrayList<>();
        if (event.getGerechten().size() == 1) {

            for (int i = 0; i < event.getGerechten().get(0).getIngredienten().size(); i++) {
                ingredienten.add(new Ingredient(event.getGerechten().get(0).getIngredienten().get(i).getNaam(), event.getGerechten().get(0).getIngredienten().get(i).getAantal()));
            }
            Gerecht gerecht = new Gerecht(event.getGerechten().get(0).getId(), event.getGerechten().get(0).getNaam(), event.getGerechten().get(0).getPrijs(), event.getGerechten().get(0).getAantal(), ingredienten);
            // van DTO naar normaal object
            gerechten.add(gerecht);
            commandHandler.sendMessage(new AlleGerechten(commandHandler.geefAlleBeschikbareGerechten(gerechten)));
        } else {
            for (int i = 0; i < event.getGerechten().get(0).getIngredienten().size(); i++) {
                ingredienten.add(new Ingredient(event.getGerechten().get(0).getIngredienten().get(i).getNaam(), event.getGerechten().get(0).getIngredienten().get(i).getAantal()));
            }

            for (int i = 0; i < event.getGerechten().size(); i++) {
                gerechten.add(new Gerecht(event.getGerechten().get(i).getId(), event.getGerechten().get(i).getNaam(), event.getGerechten().get(i).getPrijs(), event.getGerechten().get(i).getAantal(), ingredienten));
            }
            // van DTO naar normaal object

            commandHandler.sendMessage(new AlleGerechten(commandHandler.geefAlleBeschikbareGerechten(gerechten)));
        }
        System.out.println("NORMALE LISTEN: "+ event.toString());
    }
//
//    @RabbitListener(queues = {"gerecht-keywords"})
//    void listen(String event) {
//        System.out.println("TEST WERKT: "+event);
//
//    }
}

