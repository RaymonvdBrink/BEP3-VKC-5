package com.gerecht.gerecht.infrastructure.driven.messaging;

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

    public void publish(GerechtEvent event) {
        this.rabbitTemplate.convertAndSend(gerechtBoardExchange, event.getEventKey(), event);
    }
}