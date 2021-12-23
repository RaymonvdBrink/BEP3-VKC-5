package com.gerecht.gerecht.infrastructure.driver.web.event;

import java.util.UUID;

public class BesteldeGerechtDTO {
    private String id;
    private String naam;
    private double prijs;
    private int aantal;

    public BesteldeGerechtDTO(String id, String naam, double prijs, int aantal) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setAantal(int aantal) {
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

