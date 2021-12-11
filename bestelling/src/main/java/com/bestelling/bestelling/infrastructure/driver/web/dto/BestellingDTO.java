package com.bestelling.bestelling.infrastructure.driver.web.dto;

import java.util.Map;
import java.util.UUID;

public class BestellingDTO {
    private UUID klantId;
    private Map<UUID, Integer> bestelingLijst;

    public BestellingDTO() {

    }

    public UUID getKlantId() {
        return klantId;
    }

    public void setKlantId(UUID klantId) {
        this.klantId = klantId;
    }

    public Map<UUID, Integer> getBestelingLijst() {
        return bestelingLijst;
    }

    public void setBestelingLijst(Map<UUID, Integer> bestelingLijst) {
        this.bestelingLijst = bestelingLijst;
    }
}


