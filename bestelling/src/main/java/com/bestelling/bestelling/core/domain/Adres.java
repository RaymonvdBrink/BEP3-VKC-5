package com.bestelling.bestelling.core.domain;

public class Adres {

    private String plaats;

    private String postcode;

    public Adres(String plaats, String postcode) {
        this.plaats = plaats;
        this.postcode = postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getPostcode() {
        return postcode;
    }
}
