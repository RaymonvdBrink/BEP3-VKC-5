package com.voorraad.voorraad.core.domain;

import com.voorraad.voorraad.core.domain.Ingredient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "Gerecht")
public class Gerecht {

    @Id
    private String id;
    private String naam;
    private double prijs;
    private int aantal;
    private List<Ingredient> ingredienten;
    private boolean beschikbaarheid;

    public void setBeschikbaarheid(boolean beschikbaarheid) {
        this.beschikbaarheid = beschikbaarheid;
    }
    public boolean getBeschikbaarheid(){
        return beschikbaarheid;
    }

    public Gerecht(String id, String naam, double prijs, int aantal, List<Ingredient> ingredienten) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
        this.ingredienten = ingredienten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public List<Ingredient> getIngredienten() {
        return ingredienten;
    }

    public void setIngredienten(List<Ingredient> ingredienten) {
        this.ingredienten = ingredienten;
    }

    public void voegIngredientToe(String naam, int aantal){
        ingredienten.add(new Ingredient(naam, aantal));
    }
}
