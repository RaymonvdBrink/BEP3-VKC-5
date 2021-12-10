package com.bestelling.bestelling.core.application.query;

import com.bestelling.bestelling.core.domain.Bestelling;
import com.bestelling.bestelling.core.domain.Gerecht;
import com.bestelling.bestelling.core.domain.GerechtLijstItem;
import com.bestelling.bestelling.core.domain.Klant;
import com.bestelling.bestelling.core.domain.event.BesteldeGerechten;
import com.bestelling.bestelling.core.ports.messaging.BestellingEventPublisher;
import com.bestelling.bestelling.core.ports.storage.BestellingRepository;
import com.bestelling.bestelling.core.ports.storage.GerechtLijstRepository;
import com.bestelling.bestelling.core.ports.storage.KlantRepository;
import com.bestelling.bestelling.infrastructure.driven.messaging.RabbitMqEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BestellingCommandHandler {
    private final BestellingRepository bestellingRepository;
    private final GerechtLijstRepository gerechtLijstRepository;
    private final KlantRepository klantRepository;
    private final RabbitMqEventPublisher eventPublisher;

    public BestellingCommandHandler(BestellingRepository bestellingRepository,
                                    GerechtLijstRepository gerechtLijstRepository,
                                    KlantRepository klantRepository, RabbitMqEventPublisher eventPublisher) {
        this.bestellingRepository = bestellingRepository;
        this.gerechtLijstRepository = gerechtLijstRepository;
        this.klantRepository = klantRepository;
        this.eventPublisher = eventPublisher;
    }

    public void saveBestelling(Bestelling bestelling){
        bestellingRepository.save(bestelling);
    }

    public void saveKlant(Klant klant){
        klantRepository.save(klant);
    }

    public void saveGerechtLijst(List<GerechtLijstItem> lijst){
        gerechtLijstRepository.saveAll(lijst);
    }

    public void updateBesteldeGerechten(Bestelling bestelling){
        BesteldeGerechten besteldeGerechten = new BesteldeGerechten(bestelling.getId(), bestelling.getGerechten());
        eventPublisher.publish(besteldeGerechten);
    }
}
