package com.bestelling.bestelling.core.ports.storage;

import com.bestelling.bestelling.core.domain.Klant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface KlantRepository  extends MongoRepository<Klant, UUID> {
}
