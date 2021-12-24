package com.gerecht.gerecht.infrastructure.driver.web.event;

public class IngredientDTO {
    private String naam;
    private int aantal;

    public IngredientDTO(String naam, int aantal) {
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

    @Override
    public String toString() {
        return "IngredientDTO{" +
                "naam='" + naam + '\'' +
                ", aantal=" + aantal +
                '}';
    }
}
