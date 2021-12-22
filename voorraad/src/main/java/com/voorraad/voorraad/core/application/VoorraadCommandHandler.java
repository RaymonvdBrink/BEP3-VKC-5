package com.voorraad.voorraad.core.application;

import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.core.port.storage.GerechtRepository;
import com.voorraad.voorraad.core.port.storage.VoorraadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoorraadCommandHandler {
    private final VoorraadRepository voorraadRepository;
    private final GerechtRepository gerechtRepository;


    public VoorraadCommandHandler(VoorraadRepository voorraadRepository, GerechtRepository gerechtRepository) {
        this.voorraadRepository = voorraadRepository;
        this.gerechtRepository = gerechtRepository;
    }

    public void createVoorraad(Voorraad voorraad) {
        voorraadRepository.save(voorraad);
    }

    public void deleteVoorraad(String id) {
        voorraadRepository.deleteById(id);
    }
    public List<Voorraad> getVoorraad(){
        return voorraadRepository.findAll();
    }
}




//    public void updateVoorraad(VoorraadEvent voorraad){
//        voorraad = new VoorraadEvent(voorraad.getEventId());
//        eventPublisher.publish(voorraad);
//    }

