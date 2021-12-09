package com.gerecht.gerecht.domain;

import org.springframework.data.annotation.Id;

public class Gerecht {
    @Id
    private int id;
    private String naam;
    private boolean verkocht;
    private String beschrijving;



    public Gerecht(String naam, boolean verkocht, String beschrijving){
        this.naam = naam;
        this.verkocht = verkocht;
        this.beschrijving = beschrijving;
    }

}
