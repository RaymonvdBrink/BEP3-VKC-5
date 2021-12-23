package com.gerecht.gerecht.infrastructure.driver.web.event;

import com.gerecht.gerecht.core.application.GerechtCommandHandler;
import com.gerecht.gerecht.core.domain.Event.LijstGerechten;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.core.domain.Ingredient;
import com.gerecht.gerecht.infrastructure.driven.messaging.RabbitMqEventPublisher;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechten;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechtenDTO;

import com.voorraad.voorraad.infrastructure.driver.web.dto.VoorraadDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RabbitMqEventListener {
    private final GerechtCommandHandler commandHandler;


    public RabbitMqEventListener(GerechtCommandHandler commandHandler) {
        this.commandHandler = commandHandler;

    }

    @RabbitListener(queues = {"voorraad-keywords"})
    void listen(LijstGerechten event) {
        System.out.println("message has been received!: "+event.getGerechten().get(0));
        //commandHandler.stuurAlleBeschikbareGerechten(event);
    }

    @RabbitListener(queues = {"bestelling-keywords"})
    void listen2(Besteldegerechten event) {
        for (GerechtDTO item:event.getGerechten()
             ) {
            Gerecht gerecht = commandHandler.getGerecht(item.getId());
            List<Ingredient> ingredienten = gerecht.getIngredienten();
            List<IngredientDTO> ingredientenDTO = new ArrayList<>();
            for (Ingredient ingredient: ingredienten
                 ) {
                ingredientenDTO.add(new IngredientDTO(ingredient.getNaam(), ingredient.getAantal()));

            }
            item.setIngredienten(ingredientenDTO);

        }
        commandHandler.StuurberschikbaregerechtenBestelling(event);
    }
}