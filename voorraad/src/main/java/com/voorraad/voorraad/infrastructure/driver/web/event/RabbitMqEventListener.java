package com.voorraad.voorraad.infrastructure.driver.web.event;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.voorraad.voorraad.core.application.VoorraadCommandHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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
    void listen(GerechtDTO gerechtDTO) {
        Gerecht gerecht = new Gerecht(gerechtDTO.getId(), gerechtDTO.getNaam(), gerechtDTO.getPrijs(), gerechtDTO.getAantal());
        for (int i = 0; i < gerechtDTO.getIngredienten().size(); i++) {
            gerecht.voegIngredientToe(gerechtDTO.getIngredienten().get(i).getNaam(), gerechtDTO.getIngredienten().get(i).getAantal());
        }

    }
}

