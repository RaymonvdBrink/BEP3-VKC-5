package com.example.temp;

import com.example.temp.model.HelloWorld;
import com.example.temp.persistence.SpringHelloWorldRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final SpringHelloWorldRepository repo;

    public DataInitializer(SpringHelloWorldRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public void run(String... args) {
        HelloWorld helloWorld = new HelloWorld("Hello world");

        repo.save(helloWorld);

    }
}
