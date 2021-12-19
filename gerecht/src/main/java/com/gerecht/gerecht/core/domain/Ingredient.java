package com.gerecht.gerecht.core.domain;

public class Ingredient {

    private String naam;
    private String beschrijving;

    public Ingredient(String naam, String beschrijving) {
        this.naam = naam;
        this.beschrijving = beschrijving;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }
}
