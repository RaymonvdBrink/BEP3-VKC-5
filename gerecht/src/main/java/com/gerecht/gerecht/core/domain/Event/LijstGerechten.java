package com.gerecht.gerecht.core.domain.Event;

import com.gerecht.gerecht.core.domain.Gerecht;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class LijstGerechten extends GerechtEvent{
    private List<Gerecht> gerechten;


    public LijstGerechten(List<Gerecht> gerechten){
        this.gerechten = gerechten;
    }

    public LijstGerechten(){}

    @Override
    public String getEventKey(){
        return "keywords.gerecht.gerecht";
    }

    public List<Gerecht> getGerechten() {
        return gerechten;
    }

    @Override
    public UUID getEventId() {
        return super.getEventId();
    }

    @Override
    public Instant getEventDate() {
        return super.getEventDate();
    }

    public void setGerechten(List<Gerecht> gerechten) {
        this.gerechten = gerechten;
    }


}
