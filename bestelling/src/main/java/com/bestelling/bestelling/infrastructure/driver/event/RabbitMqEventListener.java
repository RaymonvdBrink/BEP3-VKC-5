package com.bestelling.bestelling.infrastructure.driver.event;

import com.bestelling.bestelling.core.application.query.BestellingCommandHandler;
import com.bestelling.bestelling.core.domain.Adres;
import com.bestelling.bestelling.core.domain.GerechtLijstItem;
import com.bestelling.bestelling.core.domain.Klant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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

    @RabbitListener(queues = {"gerecht2-keywords"})
    void listen(BeschikbareGerechtenDTO itemList){
        System.out.println("HELLO: "+itemList.toString());
        List<GerechtLijstItem> gerechtenList = new ArrayList();
        for (GerechtenDTO dto: itemList.getGerechten()) {
            gerechtenList.add(new GerechtLijstItem(dto.getId(), dto.getNaam(), dto.getPrijs()));
        }
        serviceCommand.deleteGerechtLijst();
        serviceCommand.saveGerechtLijst(gerechtenList);
    }
}
