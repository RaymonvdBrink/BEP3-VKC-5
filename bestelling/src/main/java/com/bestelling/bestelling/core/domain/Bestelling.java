package com.bestelling.bestelling.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public class Bestelling {
    @Id
    private UUID id;

    private Status status;

    private List<Gerecht> gerechten;

    private Adres adres;

    private String klantnaam;

    public Bestelling(Status status, List<Gerecht> gerechten, Adres adres, String klantnaam) {
        this.id = UUID.randomUUID();
        this.status = status;
        this.gerechten = gerechten;
        this.adres = adres;
        this.klantnaam = klantnaam;
    }

    public UUID getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public List<Gerecht> getGerechten() {
        return gerechten;
    }

    public Adres getAdres() {
        return adres;
    }

    public String getKlantnaam() {
        return klantnaam;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
