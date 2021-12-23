package com.gerecht.gerecht.infrastructure.driver.web.event;

import com.gerecht.gerecht.core.application.GerechtCommandHandler;
import com.gerecht.gerecht.core.domain.Event.LijstGerechten;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.core.domain.Ingredient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RabbitMqEventListener {
    private final GerechtCommandHandler commandHandler;
    private final GerechtCommandHandler serviceCommand;

    public RabbitMqEventListener(GerechtCommandHandler commandHandler, GerechtCommandHandler serviceCommand) {
        this.commandHandler = commandHandler;
        this.serviceCommand = serviceCommand;
    }

    @RabbitListener(queues = {"voorraad-keywords"})
    void listen(List<GerechtDTO> event) {
        List<Gerecht> gerechten = new ArrayList<>();
        for(int i = 0;i<event.size();i++) {
            List<Ingredient> ingredienten = new ArrayList<>();
            for (int i2 = 0; i2 < event.get(i).getIngredienten().size(); i2++) {
                ingredienten.add(new Ingredient(event.get(i).getIngredienten().get(i2).getNaam(), event.get(i).getIngredienten().get(i2).getAantal()));
            }
            Gerecht gerecht = new Gerecht(event.get(i).getId(), event.get(i).getNaam(), event.get(i).getPrijs(), event.get(i).getAantal(), ingredienten);
            gerecht.setBeschikbaarheid(event.get(i).getbeschikbaarheid());
            gerechten.add(gerecht);
        }
        commandHandler.updateDatabase(gerechten);
        commandHandler.stuurAlleGerechten();
    }

    @RabbitListener(queues = {"bestelling-keywords"})
    void listen2(LijstGerechten gerechten) {
        commandHandler.stuurAlleBeschikbareGerechten(gerechten);

    }
}