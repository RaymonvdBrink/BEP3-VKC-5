package com.bestelling.bestelling.infrastructure.driver.event;

import com.bestelling.bestelling.core.domain.Bestelling;
import com.bestelling.bestelling.core.domain.Gerecht;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class BestellingKeywordEvent {
    public UUID eventId;
    public String eventKey;
    public Instant eventDate;
    public List<Gerecht> bestelling;
}
