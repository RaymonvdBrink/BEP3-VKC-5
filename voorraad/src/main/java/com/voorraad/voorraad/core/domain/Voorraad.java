package com.voorraad.voorraad.core.domain;

import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;

public class Voorraad {

    @GeneratedValue
    @Id
    private Long id;

    private String naam;
    private ArrayList<Item> items = new ArrayList<>();

    public Voorraad(String naam) {
        this.naam = naam;
    }
}
