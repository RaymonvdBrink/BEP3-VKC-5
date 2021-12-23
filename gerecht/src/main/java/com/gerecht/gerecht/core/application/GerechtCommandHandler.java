package com.gerecht.gerecht.core.application;

import com.gerecht.gerecht.core.domain.Event.AlleGerechten;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.core.ports.storage.GerechtRepository;
import com.gerecht.gerecht.core.ports.storage.VoorraadRepository;
import com.gerecht.gerecht.infrastructure.driven.messaging.RabbitMqEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerechtCommandHandler {
    private final GerechtRepository gerechtRepository;
    private final VoorraadRepository voorraadRepository;
    private final RabbitMqEventPublisher eventPublisher;

    public GerechtCommandHandler(GerechtRepository gerechtRepository, VoorraadRepository voorraadRepository, RabbitMqEventPublisher eventPublisher) {
        this.gerechtRepository = gerechtRepository;
        this.voorraadRepository = voorraadRepository;
        this.eventPublisher = eventPublisher;
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

    public void stuurAlleGerechten(){
        AlleGerechten gerechten = new AlleGerechten(getAlleGerechten());
        System.out.println(getAlleGerechten().toString());
        eventPublisher.publish(gerechten);
    }


}
