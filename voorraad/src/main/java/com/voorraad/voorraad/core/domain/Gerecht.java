package com.gerecht.gerecht.core.domain;

import com.voorraad.voorraad.core.domain.Ingredient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "Gerecht")
public class Gerecht {

    @MongoId
    private String id;
    private String naam;
    private double prijs;
    private int aantal;
    private List<Ingredient> ingredientList = new ArrayList<>();


    public Gerecht(String id, String naam, double prijs, int aantal) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
    }

    public void voegIngredientToe(String naam, int aantal){
        ingredientList.add(new Ingredient(naam, aantal));
    }
}
