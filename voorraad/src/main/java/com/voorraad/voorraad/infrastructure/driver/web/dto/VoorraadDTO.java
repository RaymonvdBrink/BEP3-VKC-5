package com.voorraad.voorraad.infrastructure.driver.web.dto;

import com.voorraad.voorraad.core.domain.Ingredient;

import java.util.List;

public class VoorraadDTO {
    private String id;
    private String naam;
    private List<IngredientDTO> ingredienten;

    public String getName() {
        return naam;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredienten;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIngredienten(List<IngredientDTO> ingredienten) {
        this.ingredienten = ingredienten;
    }

    public List<IngredientDTO> getIngredienten() {
        return ingredienten;
    }

    public String getNaam() {
        return naam;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "VoorraadDTO{" +
                "id='" + id + '\'' +
                ", naam='" + naam + '\'' +
                ", ingredienten=" + ingredienten +
                '}';
    }
}
