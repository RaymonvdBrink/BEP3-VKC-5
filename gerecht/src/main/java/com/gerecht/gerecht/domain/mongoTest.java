package com.gerecht.gerecht.domain;

import com.gerecht.gerecht.GerechtApplication;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class mongoTest {

    public static void main(String[] args) {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");


        MongoOperations mongoOps = new MongoTemplate(client, "gerechtDatabase");
        mongoOps.save(new Gerecht("cheese burger", "cheese burger", 5.50));


        System.out.println(mongoOps.findOne(new Query(where("name").is("cheese burger")), Gerecht.class));

        mongoOps.dropCollection("cheese burger");

    }
}
