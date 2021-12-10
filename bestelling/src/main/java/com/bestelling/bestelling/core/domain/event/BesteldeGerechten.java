package com.bestelling.bestelling.core.domain.event;

import com.bestelling.bestelling.core.domain.Gerecht;

import java.util.List;
import java.util.UUID;

public class BesteldeGerechten extends BestellingEvent{
    private final UUID bestelling;
    private final List<Gerecht> gerechten;

    public BesteldeGerechten(UUID bestelling, List<Gerecht> gerechten) {
        this.bestelling = bestelling;
        this.gerechten = gerechten;
    }

    @Override
    public String getEventKey() {
        return "keywords.bestelling.besteld";
    }

    public UUID getBestelling() {
        return bestelling;
    }

    public List<Gerecht> getGerechten() {
        return gerechten;
    }
}
