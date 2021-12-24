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
    private boolean beschikbaarheid;

    public double getPrijs() {
        return prijs;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
    public boolean getbeschikbaarheid(){
        return beschikbaarheid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public void setIngredienten(List<IngredientDTO> ingredienten) {
        this.ingredienten = ingredienten;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
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

    @Override
    public String toString() {
        return "GerechtDTO{" +
                "id='" + id + '\'' +
                ", naam='" + naam + '\'' +
                ", prijs=" + prijs +
                ", aantal=" + aantal +
                ", ingredienten=" + ingredienten +
                ", beschikbaarheid=" + beschikbaarheid +
                '}';
    }
}
