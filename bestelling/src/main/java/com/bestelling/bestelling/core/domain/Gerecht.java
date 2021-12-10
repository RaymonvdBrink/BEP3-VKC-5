package com.bestelling.bestelling.core.domain;

import java.util.UUID;

public class Gerecht {
    private UUID id;
    private String naam;
    private double prijs;
    private int aantal;

    public Gerecht(UUID id, String naam, double prijs, int aantal) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
    }

    public UUID getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getAantal() {
        return aantal;
    }
}
