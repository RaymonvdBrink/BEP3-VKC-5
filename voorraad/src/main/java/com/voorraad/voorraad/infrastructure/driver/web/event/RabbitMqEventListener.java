package com.voorraad.voorraad.infrastructure.driver.web.event;

import com.voorraad.voorraad.core.application.VoorraadCommandHandler;
import com.voorraad.voorraad.core.domain.Gerecht;
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
void listen(Gerecht gerecht) {
    //System.out.println(user.getEmail());
//    Gerecht gerecht = gerecht.getNaam;
//    Gerecht gerecht = new Gerecht(gerechtDTO.getId(), gerechtDTO.getNaam(), gerechtDTO.getPrijs(), gerechtDTO.getAantal());
//    Klant klant = new Klant(UUID.fromString("3148debc-b398-4bbb-8dd3-14525de9e728"), user.getFirstName(), user.getLastName(), adres);
//    serviceCommand.saveKlant(klant);
    System.out.println("gerecht");
}
}

