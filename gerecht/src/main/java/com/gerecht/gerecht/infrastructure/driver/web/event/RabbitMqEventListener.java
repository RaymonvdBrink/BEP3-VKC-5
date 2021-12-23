package com.gerecht.gerecht.infrastructure.driver.web.event;

import com.gerecht.gerecht.core.application.GerechtCommandHandler;
import com.gerecht.gerecht.core.domain.Event.LijstGerechten;
import com.gerecht.gerecht.infrastructure.driven.messaging.RabbitMqEventPublisher;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechten;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechtenDTO;
import com.voorraad.voorraad.infrastructure.driver.web.dto.VoorraadDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventListener {
    private final GerechtCommandHandler commandHandler;
    private final GerechtCommandHandler serviceCommand;

    public RabbitMqEventListener(GerechtCommandHandler commandHandler, GerechtCommandHandler serviceCommand) {
        this.commandHandler = commandHandler;
        this.serviceCommand = serviceCommand;
    }

    @RabbitListener(queues = {"voorraad-keywords"})
    void listen(LijstGerechten event) {
        System.out.println("message has been received!: "+event.getGerechten().get(0));
        //commandHandler.stuurAlleBeschikbareGerechten(event);
    }

    @RabbitListener(queues = {"bestelling-keywords"})
    void listen2(LijstGerechten gerechten) {                     // TODO: met raymon verbinden
        commandHandler.stuurAlleBeschikbareGerechten(gerechten);
    }
}