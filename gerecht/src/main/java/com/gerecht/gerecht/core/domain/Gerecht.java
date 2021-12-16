package com.gerecht.gerecht.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;

@Document(collection = "Gerecht")
public class Gerecht {

    @GeneratedValue
    @Id
    private int id;

    private String naam;
    private String beschrijving;
    private double prijs;



    public Gerecht(String naam, String beschrijving, double prijs){
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;

    }

}
