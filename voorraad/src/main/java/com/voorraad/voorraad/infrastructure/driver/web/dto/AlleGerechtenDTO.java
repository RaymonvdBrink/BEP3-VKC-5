package com.voorraad.voorraad.infrastructure.driver.web.dto;


import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class AlleGerechtenDTO {
    private UUID eventId;
    private Instant eventDate;
    private String eventKey;
    private List<GerechtDTO> gerechten;

    public AlleGerechtenDTO(UUID eventId, Instant eventDate, String eventKey, List<GerechtDTO> gerechten) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.eventKey = eventKey;
        this.gerechten = gerechten;
    }
    public AlleGerechtenDTO(){}

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public void setEventDate(Instant eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public void setGerechten(List<GerechtDTO> gerechten) {
        this.gerechten = gerechten;
    }

    public UUID getEventId() {
        return eventId;
    }

    public Instant getEventDate() {
        return eventDate;
    }

    public String getEventKey() {
        return eventKey;
    }

    public List<GerechtDTO> getGerechten() {
        return gerechten;
    }

    @Override
    public String toString() {
        return "AlleGerechtenDTO{" +
                "eventId=" + eventId +
                ", eventDate=" + eventDate +
                ", eventKey='" + eventKey + '\'' +
                ", gerechten=" + gerechten +
                '}';
    }
}
