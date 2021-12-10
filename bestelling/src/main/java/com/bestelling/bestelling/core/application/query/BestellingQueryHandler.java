package com.bestelling.bestelling.core.application.query;

import com.bestelling.bestelling.core.domain.Bestelling;
import com.bestelling.bestelling.core.domain.GerechtLijstItem;
import com.bestelling.bestelling.core.domain.Klant;
import com.bestelling.bestelling.core.ports.storage.BestellingRepository;
import com.bestelling.bestelling.core.ports.storage.GerechtLijstRepository;
import com.bestelling.bestelling.core.ports.storage.KlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BestellingQueryHandler {
    private final BestellingRepository bestellingRepository;
    private final GerechtLijstRepository gerechtLijstRepository;
    private final KlantRepository klantRepository;

    public BestellingQueryHandler(BestellingRepository bestellingRepository, GerechtLijstRepository gerechtLijstRepository, KlantRepository klantRepository) {
        this.bestellingRepository = bestellingRepository;
        this.gerechtLijstRepository = gerechtLijstRepository;
        this.klantRepository = klantRepository;
    }

    public List<Bestelling> getAllBestelling(){
        return bestellingRepository.findAll();
    }

    public Klant getKlantById(UUID id){
        Optional<Klant> klant = klantRepository.findById(id);

        if(klant.isPresent()) {
            return klant.get();
        } else {
            return null;
        }
    }

    public GerechtLijstItem getGerechtLijstItemById(UUID id){
        Optional<GerechtLijstItem> gerecht = gerechtLijstRepository.findById(id);

        if(gerecht.isPresent()) {
            return gerecht.get();
        } else {
            return null;
        }
    }

}
