package com.voorraad.voorraad.core.domain;

import org.springframework.data.annotation.Id;


import java.util.ArrayList;

public class Voorraad {


    @Id
    private Long id;

    private String naam;
    private ArrayList<Item> items = new ArrayList<>();

    public Voorraad(String naam) {
        this.naam = naam;
    }
}
