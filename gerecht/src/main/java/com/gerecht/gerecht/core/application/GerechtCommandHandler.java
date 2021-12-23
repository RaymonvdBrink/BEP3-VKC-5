package com.gerecht.gerecht.core.application;

import com.gerecht.gerecht.core.domain.Event.LijstGerechten;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.core.ports.storage.GerechtRepository;
import com.gerecht.gerecht.core.ports.storage.VoorraadRepository;
import com.gerecht.gerecht.infrastructure.driven.messaging.RabbitMqEventPublisher;
import com.gerecht.gerecht.infrastructure.driver.web.event.Besteldegerechten;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechtenDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void deleteGerecht(String id){
        gerechtRepository.delete(getGerecht(id));
    }

    public Gerecht getGerecht(String id){
        return gerechtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("gerecht bestaat niet"));
    }

    public List<Gerecht> getAlleGerechten(){
        return gerechtRepository.findAll();
    }

    public void stuurAlleGerechten(){

        LijstGerechten gerechten = new LijstGerechten(getAlleGerechten());
        System.out.println(getAlleGerechten().toString());
        eventPublisher.publishToVoorraad(gerechten);
    }
//    public void stuurAlleBeschikbareGerechten(LijstGerechten event){
//
//        List<Gerecht> gerechten = new ArrayList<>();
//        for(int i =0;i<event.getGerechten().size();i++){
//            if(event.getGerechten().get(i).getBeschikbaarheid() == true){
//                gerechten.add(event.getGerechten().get(i));
//            }
//        }
//        event.setGerechten(gerechten);
//        eventPublisher.publishNaarBestelling(event);
//
//
//    }
    public void StuurberschikbaregerechtenBestelling(Besteldegerechten event){
        eventPublisher.publishNaarBestelling(event);
    }
    public void StuurGerechtenNaarBestelling(LijstGerechten event){
//        Besteldegerechten besteldeGerechten = new Besteldegerechten(event.getBestelling(), event.getGerechten());
        eventPublisher.publishToBestelling(event);

//        eventPublisher.publishToBestelling(besteldeGerechten);
    }

}
