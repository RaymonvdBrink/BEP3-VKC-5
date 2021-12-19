package com.bestelling.bestelling.infrastructure.driver.event;

import com.bestelling.bestelling.core.application.query.BestellingCommandHandler;
import com.bestelling.bestelling.core.domain.Adres;
import com.bestelling.bestelling.core.domain.Klant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RabbitMqEventListener {
    private final BestellingCommandHandler commandHandler;
    private final BestellingCommandHandler serviceCommand;

    public RabbitMqEventListener(BestellingCommandHandler commandHandler, BestellingCommandHandler serviceCommand) {
        this.commandHandler = commandHandler;
        this.serviceCommand = serviceCommand;
    }

    @RabbitListener(queues = {"post_user_queue"})
    void listen(UserDTO user) {
        //System.out.println(user.getEmail());
        Address address = user.getAddress();
        Adres adres = new Adres(
                address.getCity(),
                address.getStreet(),
                Integer.toString(address.getHouseNumber()),
                address.getPostcode());
        Klant klant = new Klant(UUID.fromString("3148debc-b398-4bbb-8dd3-14525de9e728"), user.getFirstName(), user.getLastName(), adres);
        serviceCommand.saveKlant(klant);
    }
}
