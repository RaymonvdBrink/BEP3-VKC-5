package com.gerecht.gerecht.infrastructure.driver.web.event;

public class IngredientDTO {
    private String naam;
    private int aantal;


    public String getNaam() {
        return naam;
    }

    public int getAantal() {
        return aantal;
    }

    @Override
    public String toString() {
        return "IngredientDTO{" +
                "naam='" + naam + '\'' +
                ", aantal=" + aantal +
                '}';
    }
}
