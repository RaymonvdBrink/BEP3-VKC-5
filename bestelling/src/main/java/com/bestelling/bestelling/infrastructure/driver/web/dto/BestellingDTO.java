package com.bestelling.bestelling.infrastructure.driver.web.dto;

import java.util.Map;
import java.util.UUID;

public class BestellingDTO {
    private UUID klantId;
    private Map<String, Integer> bestelingLijst;

    public BestellingDTO() {

    }

    public UUID getKlantId() {
        return klantId;
    }

    public void setKlantId(UUID klantId) {
        this.klantId = klantId;
    }

    public Map<String, Integer> getBestelingLijst() {
        return bestelingLijst;
    }

    public void setBestelingLijst(Map<String, Integer> bestelingLijst) {
        this.bestelingLijst = bestelingLijst;
    }
}


