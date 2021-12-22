package com.voorraad.voorraad.infrastructure.driver.web.event;

import com.voorraad.voorraad.infrastructure.driver.web.dto.IngredientDTO;

import java.util.List;

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
