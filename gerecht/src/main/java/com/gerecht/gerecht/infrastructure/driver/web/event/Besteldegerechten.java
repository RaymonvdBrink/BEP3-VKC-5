package com.gerecht.gerecht.infrastructure.driver.web.event;

import java.util.List;
import java.util.UUID;

public class Besteldegerechten {
    private  UUID bestelling;
    private  List<GerechtDTO> gerechten;

    public Besteldegerechten(UUID bestelling, List<GerechtDTO> gerechten) {
        this.bestelling = bestelling;
        this.gerechten = gerechten;
    }

    public UUID getBestelling() {
        return bestelling;
    }

    public List<GerechtDTO> getGerechten() {
        return gerechten;
    }
}
