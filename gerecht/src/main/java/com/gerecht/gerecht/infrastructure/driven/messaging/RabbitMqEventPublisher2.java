package com.gerecht.gerecht.infrastructure.driven.messaging;

import com.gerecht.gerecht.core.domain.Event.LijstGerechten;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqEventPublisher2 {

    private final RabbitTemplate rabbitTemplate;
    private final String gerechtBoardExchange2;


    public RabbitMqEventPublisher2(
            RabbitTemplate rabbitTemplate,
            String gerechtBoardExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.gerechtBoardExchange2 = gerechtBoardExchange;
    }


    public void publishToBestelling(LijstGerechten event) {
        this.rabbitTemplate.convertAndSend(gerechtBoardExchange2, "keywords.gerecht.gerecht2", event);
        System.out.println("message sent to bestelling: "+event.toString());
    }

}
