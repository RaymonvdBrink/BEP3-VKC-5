package com.gerecht.gerecht.core.application;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

public class GerechtService {
    private MongoOperations mongoOps = new MongoTemplate(MongoClients.create("mongodb://localhost:27017"), "gerechtDatabase");

    public void saveGerecht(Gerecht gerecht){
        mongoOps.save(gerecht);
    }

    public void deleteGerecht(int id){
        // mongoOps.delete
    }

    public Gerecht getGerecht(){
        mongoOps.getCollection("gerecht");
        return null;
    }

}
