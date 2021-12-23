package com.voorraad.voorraad.core.port.storage;

import com.voorraad.voorraad.core.domain.Voorraad;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface VoorraadRepository extends MongoRepository<Voorraad, Long> {

    @Override
    Optional<Voorraad> findById(Long id);
}
