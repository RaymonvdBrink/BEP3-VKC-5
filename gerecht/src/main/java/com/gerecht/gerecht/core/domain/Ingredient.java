package com.gerecht.gerecht.core.domain;

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
}
