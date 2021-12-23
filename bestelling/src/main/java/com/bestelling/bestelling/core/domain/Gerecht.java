package com.bestelling.bestelling.core.domain;

public class Gerecht {
    private String id;
    private String naam;
    private double prijs;
    private int aantal;

    public Gerecht(String id, String naam, double prijs, int aantal) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
    }

    public String getId() {
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
