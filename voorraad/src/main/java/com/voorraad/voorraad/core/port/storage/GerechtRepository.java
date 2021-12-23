package com.voorraad.voorraad.core.port.storage;

import com.voorraad.voorraad.core.domain.Gerecht;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GerechtRepository extends MongoRepository<Gerecht, String> {
}
