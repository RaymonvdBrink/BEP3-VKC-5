package com.bestelling.bestelling.core.domain;

public class Adres {

    private String plaats;

    private String straat;

    private String huisnummer;

    private String postcode;

    public Adres(String plaats, String straat, String huisnummer, String postcode) {
        this.plaats = plaats;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getPostcode() {
        return postcode;
    }
}
