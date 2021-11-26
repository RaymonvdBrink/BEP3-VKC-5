package com.example.temp.application;

import com.example.temp.model.HelloWorld;
import com.example.temp.persistence.SpringHelloWorldRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class HelloWorldService {
    private final SpringHelloWorldRepository helloWorldRepository;

    public HelloWorldService(SpringHelloWorldRepository service){
        this.helloWorldRepository = service;
    }

    public HelloWorld getHelloWorld(){
        Optional<HelloWorld> helloWorld = helloWorldRepository.findById(Long.valueOf(1));

        if(helloWorld.isPresent()) {
            return helloWorld.get();
        } else {
            return null;
        }
    }
}
