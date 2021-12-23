package com.bestelling.bestelling.infrastructure.driver.event;

public class GerechtenDTO {
    private String id;
    private String naam;
    private double prijs;

    public GerechtenDTO(String id, String naam, double prijs) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "GerechtenDTO{" +
                "id='" + id + '\'' +
                ", naam='" + naam + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
