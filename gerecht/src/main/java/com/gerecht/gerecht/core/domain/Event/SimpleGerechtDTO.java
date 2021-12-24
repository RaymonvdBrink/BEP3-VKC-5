package com.gerecht.gerecht.core.domain.Event;

import java.util.UUID;

public class SimpleGerechtDTO {
    private String id;
    private String naam;
    private double prijs;
    private int aantal;

    public SimpleGerechtDTO(String id, String naam, double prijs, int aantal) {
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
