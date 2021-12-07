package com.example.temp.persistence;

import com.example.temp.model.HelloWorld;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringHelloWorldRepository extends MongoRepository<HelloWorld, Long> {
}
