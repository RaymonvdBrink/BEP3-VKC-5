package com.gerecht.gerecht.infrastructure.driver.web.dto;

public class GerechtDTO {
    private String naam;
    private String beschrijving;
    private double prijs;

    public double getPrijs() {
        return prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getNaam() {
        return naam;
    }
}
