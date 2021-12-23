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

    public void publish(AlleGerechten event) {
        this.rabbitTemplate.convertAndSend(gerechtBoardExchange, event.getEventKey(), event);
//        GerechtEvent gerecht = new GerechtEvent();
//        this.rabbitTemplate.convertAndSend("gerechtboard", "keywords.gerecht.gerecht", gerecht);
    }
}
