package com.gerecht.gerecht.core.ports.storage;

import com.gerecht.gerecht.core.domain.Gerecht;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface GerechtRepository extends MongoRepository<Gerecht, String> {

}
