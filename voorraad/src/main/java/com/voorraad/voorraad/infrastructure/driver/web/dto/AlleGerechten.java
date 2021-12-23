package com.voorraad.voorraad.infrastructure.driver.web.dto;

import com.voorraad.voorraad.core.domain.Gerecht;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class AlleGerechten extends GerechtEvent{
    private List<Gerecht> gerechten;


    public AlleGerechten(List<Gerecht> gerechten){
        this.gerechten = gerechten;
    }

    public AlleGerechten(){}

    @Override
    public String getEventKey(){
        return "keywords.voorraad.voorraad";
    }

    public List<Gerecht> getGerechten() {
        return gerechten;
    }

    @Override
    public Instant getEventDate() {
        return super.getEventDate();
    }

    @Override
    public UUID getEventId() {
        return super.getEventId();
    }

    public void setGerechten(List<Gerecht> gerechten) {
        this.gerechten = gerechten;
    }

}