package com.gerecht.gerecht.infrastructure.driven.messaging;

import com.gerecht.gerecht.core.domain.Event.LijstGerechten;
import com.gerecht.gerecht.infrastructure.driver.web.event.Besteldegerechten;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechtenDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final String gerechtBoardExchange;

    public RabbitMqEventPublisher(
            RabbitTemplate rabbitTemplate,
            String gerechtBoardExchange
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.gerechtBoardExchange = gerechtBoardExchange;
    }

    public void publishToVoorraad(LijstGerechten event) {
        System.out.println("message has been sent!");
        this.rabbitTemplate.convertAndSend(gerechtBoardExchange, "keywords.gerecht.gerecht", event);
    }

    public void publishToBestelling(LijstGerechten event){
        this.rabbitTemplate.convertAndSend(gerechtBoardExchange, "keywords.gerecht.gerecht2", event);
        System.out.println("message sent to bestelling");
    }
}
