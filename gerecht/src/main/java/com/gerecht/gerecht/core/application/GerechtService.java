package com.gerecht.gerecht.core.application;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.core.ports.storage.GerechtRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerechtService {
    private final GerechtRepository gerechtRepository;

    public GerechtService(GerechtRepository gerechtRepository) {
        this.gerechtRepository = gerechtRepository;
    }

    public void createGerecht(Gerecht gerecht){
        gerechtRepository.save(gerecht);
    }

    public void deleteGerecht(Long id){
        gerechtRepository.delete(getGerecht(id));
    }

    public Gerecht getGerecht(Long id){
        return gerechtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("gerecht bestaat niet"));
    }

    public List<Gerecht> getAlleGerechten(){
        return gerechtRepository.findAll();
    }

}
