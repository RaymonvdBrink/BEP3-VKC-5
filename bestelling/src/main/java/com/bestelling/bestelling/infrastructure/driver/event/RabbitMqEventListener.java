package com.bestelling.bestelling.infrastructure.driver.event;

import com.bestelling.bestelling.core.application.query.BestellingCommandHandler;
import com.bestelling.bestelling.core.domain.Bestelling;
import com.bestelling.bestelling.core.domain.Klant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventListener {
    private final BestellingCommandHandler commandHandler;

    public RabbitMqEventListener(BestellingCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RabbitListener(queues = {"post_user_key"})
    void listen(UserDTO temp) {
        System.out.printf(temp.getEmail());
    }
}
