package com.gerecht.gerecht.port.messaging;

import com.gerecht.gerecht.GerechtApplication;
import com.gerecht.gerecht.domain.Gerecht;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@RestController
public class GerechtController {


    @RequestMapping("/gerecht")
    public Gerecht geefGerechten(){
        MongoClient client = MongoClients.create("mongodb://localhost");


        MongoOperations mongoOps = new MongoTemplate(client, "database");
        //mongoOps.insert(new Gerecht());

        mongoOps.dropCollection("someEntity");

        return null;
    }
}
