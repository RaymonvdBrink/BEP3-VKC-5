package com.gerecht.gerecht.core.ports.storage;

import com.gerecht.gerecht.core.domain.Gerecht;

import com.voorraad.voorraad.core.domain.Voorraad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoorraadRepository extends MongoRepository<Voorraad, Long> {
}
