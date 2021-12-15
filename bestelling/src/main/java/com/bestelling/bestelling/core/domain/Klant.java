package com.bestelling.bestelling.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Klant {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private Adres adres;

    public Klant(UUID id, String firstName, String lastName, Adres adres) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adres = adres;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public Adres getAdres() {
        return adres;
    }
}
