package com.voorraad.voorraad.core.domain;

import java.util.ArrayList;

public class Voorraad {
    private int aantal;
    private ArrayList items = new ArrayList<>();

    public Voorraad(int aantal) {
        this.aantal = aantal;
    }
}
