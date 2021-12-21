package com.gerecht.gerecht.core.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.util.UUID;

@Document(collection = "Gerecht")
public class Gerecht {

    @MongoId
    private UUID id;
    private String naam;
    private double prijs;
    private int aantal;


    public Gerecht(UUID id, String naam, double prijs, int aantal) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
    }
}
