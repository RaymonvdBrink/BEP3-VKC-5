package com.gerecht.gerecht.infrastructure.driver.web.event;

import java.util.UUID;

public class GerechtDTO {
    private UUID id;
    private String naam;
    private double prijs;
    private int aantal;

    public double getPrijs() {
        return prijs;
    }

    public UUID getId() {
        return id;
    }

    public int getAantal() {
        return aantal;
    }

    public String getNaam() {
        return naam;
    }
}
