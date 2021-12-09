package com.bestelling.bestelling.core.application.query;

import com.bestelling.bestelling.core.domain.Bestelling;
import com.bestelling.bestelling.core.ports.storage.BestellingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestellingQueryHandler {
    private final BestellingRepository repository;

    public BestellingQueryHandler(BestellingRepository repository) {
        this.repository = repository;
    }

    public void save(Bestelling bestelling){
        repository.save(bestelling);
    }

    public List<Bestelling> getAll(){
        return repository.findAll();
    }
}
