package com.example.temp.persistence;

import com.example.temp.model.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringHelloWorldRepository extends JpaRepository<HelloWorld, Long> {
}
