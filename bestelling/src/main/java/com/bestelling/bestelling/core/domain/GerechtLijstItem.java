package com.bestelling.bestelling.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class GerechtLijstItem {
    @Id
    private UUID id;
    private String naam;
    private double price;

    public GerechtLijstItem(UUID id, String naam, double price) {
        this.id = id;
        this.naam = naam;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrice() {
        return price;
    }
}
