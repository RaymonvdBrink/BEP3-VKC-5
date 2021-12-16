package com.gerecht.gerecht;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@SpringBootApplication
public class GerechtApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerechtApplication.class, args);
    }

}
