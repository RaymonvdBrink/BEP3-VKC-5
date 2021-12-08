package com.example.temp.presentation;

import com.example.temp.application.HelloWorldService;
import com.example.temp.model.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
    private  final HelloWorldService service;
    public HelloWorldController(HelloWorldService service) {
        this.service = service;
    }

    @GetMapping
    public HelloWorld helloWorld(){
        return service.getHelloWorld();
    }

    @GetMapping("/test")
    public HelloWorld helloWorldGet(){
        RestTemplate client = new RestTemplate();
        URI uri = URI.create("http://localhost:8082/helloworld");
        HelloWorld result =  client.getForObject(uri, HelloWorld.class);

        return result;
    }
}
