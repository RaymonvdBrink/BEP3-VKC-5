package com.gerecht.gerecht.infrastructure.driver.web.event;

import com.gerecht.gerecht.core.domain.Ingredient;

import java.util.List;
import java.util.UUID;

public class GerechtDTO {
    private String id;
    private String naam;
    private double prijs;
    private int aantal;
    private List<IngredientDTO> ingredienten;

    public double getPrijs() {
        return prijs;
    }

    public String getId() {
        return id;
    }

    public List<IngredientDTO> getIngredienten() {
        return ingredienten;
    }

    public int getAantal() {
        return aantal;
    }

    public String getNaam() {
        return naam;
    }
}
