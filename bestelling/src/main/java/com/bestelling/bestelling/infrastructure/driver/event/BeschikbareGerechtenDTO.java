package com.bestelling.bestelling.infrastructure.driver.event;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class BeschikbareGerechtenDTO {
    private UUID eventId;
    private Instant eventDate;
    private List<GerechtenDTO> gerechten;
    private String eventKey;

    public BeschikbareGerechtenDTO(UUID eventId, Instant eventDate, List<GerechtenDTO> gerechten, String eventKey) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.gerechten = gerechten;
        this.eventKey = eventKey;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public Instant getEventDate() {
        return eventDate;
    }

    public void setEventDate(Instant eventDate) {
        this.eventDate = eventDate;
    }

    public List<GerechtenDTO> getGerechten() {
        return gerechten;
    }

    public void setGerechten(List<GerechtenDTO> gerechten) {
        this.gerechten = gerechten;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public String toString() {
        return "BeschikbareGerechtenDTO{" +
                "eventId=" + eventId +
                ", eventDate=" + eventDate +
                ", gerechten=" + gerechten +
                ", eventKey='" + eventKey + '\'' +
                '}';
    }
}
