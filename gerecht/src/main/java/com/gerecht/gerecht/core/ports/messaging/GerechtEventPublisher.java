package com.gerecht.gerecht.core.ports.messaging;

import com.gerecht.gerecht.core.domain.Event.GerechtEvent;

public interface GerechtEventPublisher {
    void publish(GerechtEvent event);
}
