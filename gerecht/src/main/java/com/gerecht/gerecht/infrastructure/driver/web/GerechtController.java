package com.gerecht.gerecht.infrastructure.driver.web;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GerechtController {


    @RequestMapping("/gerecht")
    public Gerecht geefGerechten(){

        return null;
    }
}
