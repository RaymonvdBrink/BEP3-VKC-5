package com.voorraad.voorraad.infrastructure.driver.web.dto;

import com.voorraad.voorraad.infrastructure.driver.web.dto.IngredientDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;


public class GerechtDTO {
    private String id;
    private String naam;
    private double prijs;
    private int aantal;
    private List<IngredientDTO> ingredienten;
    private boolean beschikbaarheid;

    public void setBeschikbaarheid(boolean beschikbaarheid) {
        this.beschikbaarheid = beschikbaarheid;
    }
    public boolean getBeschikbaarheid(){
        return beschikbaarheid;
    }

    public GerechtDTO(String id, String naam, double prijs, int aantal) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
    }
    public GerechtDTO(){}

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

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setIngredienten(List<IngredientDTO> ingredienten) {
        this.ingredienten = ingredienten;
    }


    @Override
    public String toString() {
        return "GerechtDTO{" +
                "id='" + id + '\'' +
                ", naam='" + naam + '\'' +
                ", prijs=" + prijs +
                ", aantal=" + aantal +
                ", beschikbaarheid=" + beschikbaarheid +
                ", ingredienten=" + ingredienten +
                '}';
    }
}
