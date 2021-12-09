package com.bestelling.bestelling.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bestelling {
    @Id
    private BestellingId id;

    private Status status;

    private float prijs;

    private Adres adres;

    private String klantnaam;

    public Bestelling(BestellingId id, Status status, float prijs, Adres adres, String klantnaam) {
        this.id = id;
        this.status = status;
        this.prijs = prijs;
        this.adres = adres;
        this.klantnaam = klantnaam;
    }

    public BestellingId getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public float getPrijs() {
        return prijs;
    }

    public Adres getAdres() {
        return adres;
    }

    public String getKlantnaam() {
        return klantnaam;
    }
}
