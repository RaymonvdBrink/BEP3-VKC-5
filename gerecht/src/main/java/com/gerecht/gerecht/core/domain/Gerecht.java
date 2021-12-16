package com.gerecht.gerecht.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Gerecht")
public class Gerecht {
    @Id
    private int id;
    private String naam;
    private String beschrijving;
    private double prijs;

    //private ArrayList lijst = new ArrayList<>();


    public Gerecht(String naam, String beschrijving, double prijs){
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;

    }

}
