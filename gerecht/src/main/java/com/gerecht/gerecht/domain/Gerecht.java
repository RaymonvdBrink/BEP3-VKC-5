package com.gerecht.gerecht.domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

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

//        if(lijst.size() == 0){
//            lijst.add("pizza");
//            lijst.add("cheese burger");
//            lijst.add("frikandel");
//        }
    }

}
