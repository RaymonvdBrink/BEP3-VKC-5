package com.voorraad.voorraad.core.port.messaging;

import com.voorraad.voorraad.core.domain.event.VoorraadEvent;

public interface VoorraadEventPublisher {
    void publish(VoorraadEvent event);
}
