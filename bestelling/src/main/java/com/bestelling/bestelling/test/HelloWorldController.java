package com.bestelling.bestelling.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
    @GetMapping
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping("/test")
    public String helloWorldGet(){
        RestTemplate client = new RestTemplate();
        URI uri = URI.create("http://localhost:8085/helloworld");
        String result =  client.getForObject(uri, String.class);

        return result;
    }
}