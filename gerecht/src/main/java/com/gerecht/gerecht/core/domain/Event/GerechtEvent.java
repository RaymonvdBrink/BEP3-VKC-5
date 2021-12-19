package com.gerecht.gerecht.core.domain.Event;

import java.time.Instant;
import java.util.UUID;

public abstract class GerechtEvent {
    private final UUID eventId = UUID.randomUUID();
    private final Instant eventDate = Instant.now();

    public UUID getEventId() {
        return eventId;
    }

    public Instant getEventDate() {
        return eventDate;
    }

    public abstract String getEventKey();
}
