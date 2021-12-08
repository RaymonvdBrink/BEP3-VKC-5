package com.example.temp;

import com.example.temp.model.HelloWorld;
import com.example.temp.persistence.SpringHelloWorldRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final SpringHelloWorldRepository repo;

    public DataInitializer(SpringHelloWorldRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        Optional<HelloWorld> helloWorld = repo.findById(Long.valueOf(0));

        if(!helloWorld.isPresent()) {
            HelloWorld newHelloWorld = new HelloWorld("Hello world");

            repo.save(newHelloWorld);
        }
    }
}
