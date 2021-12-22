package com.gerecht.gerecht.core.domain.Event;

import com.gerecht.gerecht.core.domain.Gerecht;

import java.util.List;

public class AlleGerechten extends GerechtEvent{
    private List<Gerecht> gerechten;


    public AlleGerechten(List<Gerecht> gerechten){
        this.gerechten = gerechten;
    }

    @Override
    public String getEventKey() {
        return null;
    }


}
