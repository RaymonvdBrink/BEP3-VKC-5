package com.bestelling.bestelling.core.ports.storage;

import com.bestelling.bestelling.core.domain.Bestelling;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BestellingRepository extends MongoRepository<Bestelling, UUID> {
}
