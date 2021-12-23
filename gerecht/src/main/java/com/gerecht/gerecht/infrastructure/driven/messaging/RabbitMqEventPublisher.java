package com.gerecht.gerecht.infrastructure.driven.messaging;

import com.gerecht.gerecht.core.domain.Event.AlleGerechten;
import com.gerecht.gerecht.core.domain.Event.GerechtEvent;
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

    public void publishToVoorraad(AlleGerechten event) {
        System.out.println("message has been sent!");
        this.rabbitTemplate.convertAndSend(gerechtBoardExchange, "keywords.gerecht.gerecht", event);
    }

    public void publishtest(String event){
        this.rabbitTemplate.convertAndSend(gerechtBoardExchange, "keywords.gerecht.gerecht", event);

    }

    public void publishToBestelling(AlleGerechten event){
        this.rabbitTemplate.convertAndSend(gerechtBoardExchange, "keywords.gerecht.gerecht", event);
    }




}
