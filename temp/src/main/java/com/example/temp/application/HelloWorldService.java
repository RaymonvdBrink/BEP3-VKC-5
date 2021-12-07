package com.example.temp.application;

import com.example.temp.model.HelloWorld;
import com.example.temp.persistence.SpringHelloWorldRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloWorldService {
    private final SpringHelloWorldRepository helloWorldRepository;

    public HelloWorldService(SpringHelloWorldRepository service){
        this.helloWorldRepository = service;
    }

    public HelloWorld getHelloWorld(){
        Optional<HelloWorld> helloWorld = helloWorldRepository.findById(Long.valueOf(0));

        if(helloWorld.isPresent()) {
            return helloWorld.get();
        } else {
            return null;
        }
    }
}
