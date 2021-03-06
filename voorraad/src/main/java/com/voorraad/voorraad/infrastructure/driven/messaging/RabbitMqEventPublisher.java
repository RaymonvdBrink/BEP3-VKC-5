package com.voorraad.voorraad.infrastructure.driven.messaging;


import com.voorraad.voorraad.core.domain.Gerecht;
import com.voorraad.voorraad.core.domain.event.VoorraadEvent;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtDTO;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

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

    public void publish(List<GerechtDTO> event) {
        System.out.println("message sent!");
        this.rabbitTemplate.convertAndSend(voorraadBoardExchange, "keywords.voorraad.voorraad", event);
    }
}
