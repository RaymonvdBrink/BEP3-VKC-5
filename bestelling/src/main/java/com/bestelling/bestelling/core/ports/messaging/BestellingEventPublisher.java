package com.bestelling.bestelling.core.ports.messaging;

import com.bestelling.bestelling.core.domain.event.BestellingEvent;

public interface BestellingEventPublisher {
    void publish(BestellingEvent event);
}
