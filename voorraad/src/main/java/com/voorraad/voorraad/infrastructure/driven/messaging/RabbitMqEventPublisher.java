package com.voorraad.voorraad.infrastructure.driven.messaging;

import com.voorraad.voorraad.core.domain.event.VoorraadEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final String voorraadBoardExchange;

    public RabbitMqEventPublisher(
            RabbitTemplate rabbitTemplate,
            String voorraadBoardExchange
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.voorraadBoardExchange = voorraadBoardExchange;
    }

    public void publish(VoorraadEvent event) {
        this.rabbitTemplate.convertAndSend(voorraadBoardExchange, event.getEventKey(), event);
    }
}
