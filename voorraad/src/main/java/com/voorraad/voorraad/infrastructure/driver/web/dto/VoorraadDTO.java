package com.voorraad.voorraad.infrastructure.driver.web.dto;

import com.voorraad.voorraad.core.domain.Ingredient;

import java.util.List;

public class VoorraadDTO {
    private String name;
    private List<Ingredient> ingredienten;

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredienten;
    }
}
