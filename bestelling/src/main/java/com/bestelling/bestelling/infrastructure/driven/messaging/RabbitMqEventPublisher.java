package com.bestelling.bestelling.infrastructure.driven.messaging;

import com.bestelling.bestelling.core.domain.Bestelling;
import com.bestelling.bestelling.core.domain.event.BestellingEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final String bestellingBoardExchange;

    public RabbitMqEventPublisher(
            RabbitTemplate rabbitTemplate,
            String bestellingBoardExchange
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.bestellingBoardExchange = bestellingBoardExchange;
    }

    public void publish(BestellingEvent event) {
        this.rabbitTemplate.convertAndSend(bestellingBoardExchange, event.getEventKey(), event);
    }
}
