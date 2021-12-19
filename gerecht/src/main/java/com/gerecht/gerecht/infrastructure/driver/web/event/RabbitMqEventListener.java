package com.gerecht.gerecht.infrastructure.driver.web.event;

import com.gerecht.gerecht.core.application.GerechtCommandHandler;
import com.gerecht.gerecht.core.domain.Gerecht;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventListener {
    private final GerechtCommandHandler commandHandler;
    private final GerechtCommandHandler serviceCommand;

    public RabbitMqEventListener(GerechtCommandHandler commandHandler, GerechtCommandHandler serviceCommand) {
        this.commandHandler = commandHandler;
        this.serviceCommand = serviceCommand;
    }
}