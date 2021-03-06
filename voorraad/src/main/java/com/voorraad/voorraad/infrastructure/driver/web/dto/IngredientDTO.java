package com.voorraad.voorraad.infrastructure.driver.web.dto;

public class IngredientDTO {
    private String naam;
    private int aantal;

    public String getNaam() {
        return naam;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "IngredientDTO{" +
                "naam='" + naam + '\'' +
                ", aantal=" + aantal +
                '}';
    }
}
