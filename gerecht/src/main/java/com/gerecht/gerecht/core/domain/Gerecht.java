package com.gerecht.gerecht.core.domain;

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
    private List<Ingredient> ingredienten;
    private boolean beschikbaarheid;


    public Gerecht(String id, String naam, double prijs, int aantal, List<Ingredient> ingredienten) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.ingredienten = ingredienten;
    }

    public Gerecht(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getNaam() {
        return naam;
    }

    public void setBeschikbaarheid(boolean bool){
        this.beschikbaarheid = bool;
    }
    public boolean getBeschikbaarheid(){
        return beschikbaarheid;
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



    public List<Ingredient> getIngredienten() {
        return ingredienten;
    }

    public void setIngredienten(List<Ingredient> ingredienten) {
        this.ingredienten = ingredienten;
    }

    @Override
    public String toString() {
        return "Gerecht{" +
                "id='" + id + '\'' +
                ", naam='" + naam + '\'' +
                ", prijs=" + prijs +
                ", beschikbaarheid=" + beschikbaarheid+
                ", ingredienten=" + ingredienten +
                '}';
    }
   }
