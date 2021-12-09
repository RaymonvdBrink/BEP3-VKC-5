package com.bestelling.bestelling.core.ports.storage;

import com.bestelling.bestelling.core.domain.Bestelling;
import com.bestelling.bestelling.core.domain.BestellingId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BestellingRepository extends MongoRepository<Bestelling, BestellingId> {
}
