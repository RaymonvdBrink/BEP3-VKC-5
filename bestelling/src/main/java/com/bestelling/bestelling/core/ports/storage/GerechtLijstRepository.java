package com.bestelling.bestelling.core.ports.storage;

import com.bestelling.bestelling.core.domain.GerechtLijstItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface GerechtLijstRepository extends MongoRepository<GerechtLijstItem, UUID> {
}
