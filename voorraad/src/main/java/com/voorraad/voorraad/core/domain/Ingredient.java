package com.voorraad.voorraad.core.domain;

public class Ingredient {

    private String naam;
    private int aantal;

    public Ingredient(String naam, int aantal) {
        this.naam = naam;
        this.aantal = aantal;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantal() {
        return aantal;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}
