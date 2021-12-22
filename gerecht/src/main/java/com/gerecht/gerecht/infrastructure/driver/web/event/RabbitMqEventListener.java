package com.gerecht.gerecht.infrastructure.driver.web.event;

import com.gerecht.gerecht.core.application.GerechtCommandHandler;
import com.voorraad.voorraad.infrastructure.driver.web.dto.VoorraadDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventListener {
    private final GerechtCommandHandler commandHandler;
    private final GerechtCommandHandler serviceCommand;

    public RabbitMqEventListener(GerechtCommandHandler commandHandler, GerechtCommandHandler serviceCommand) {
        this.commandHandler = commandHandler;
        this.serviceCommand = serviceCommand;
    }

//    @RabbitListener(queues = {"post_user_queue"})
//    void listen(VoorraadDTO voorraadDTO) {
//
//    }
}