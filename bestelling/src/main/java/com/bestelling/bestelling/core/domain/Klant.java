package com.bestelling.bestelling.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Klant {
    @Id
    private UUID id;
    private String naam;
    private Adres adres;

    public Klant(UUID id, String naam, Adres adres) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
    }

    public UUID getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }
}
