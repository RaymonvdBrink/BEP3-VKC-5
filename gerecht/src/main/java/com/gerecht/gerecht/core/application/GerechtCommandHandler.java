package com.gerecht.gerecht.core.application;

import com.gerecht.gerecht.core.domain.Event.LijstGerechten;
import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.core.ports.storage.GerechtRepository;
import com.gerecht.gerecht.core.ports.storage.VoorraadRepository;
import com.gerecht.gerecht.infrastructure.driven.messaging.RabbitMqEventPublisher;
import com.gerecht.gerecht.infrastructure.driven.messaging.RabbitMqEventPublisher2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GerechtCommandHandler {
    private final GerechtRepository gerechtRepository;
    private final VoorraadRepository voorraadRepository;
    private final RabbitMqEventPublisher eventPublisher;
    private final RabbitMqEventPublisher2 eventPublisher2;


    public GerechtCommandHandler(GerechtRepository gerechtRepository, VoorraadRepository voorraadRepository, RabbitMqEventPublisher eventPublisher, RabbitMqEventPublisher2 eventPublisher2) {
        this.gerechtRepository = gerechtRepository;
        this.voorraadRepository = voorraadRepository;
        this.eventPublisher = eventPublisher;
        this.eventPublisher2 = eventPublisher2;
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

//    public void StuurberschikbaregerechtenBestelling(Besteldegerechten event){
//        System.out.println("verkeerde publish naar bestelling");
//        eventPublisher.publishNaarBestelling(event);
//    }
    public void StuurGerechtenNaarBestelling(LijstGerechten event){
        System.out.println("verkeerde publish naar bestelling");
        eventPublisher2.publishToBestelling(event);
    }


    public void updateIngredienten(List<Gerecht> gerechten){
        LijstGerechten besteldeGerechten = new LijstGerechten(gerechten);
        System.out.println(getAlleGerechten().toString());
        eventPublisher.publishToVoorraad(besteldeGerechten);
    }

    public void stuurAlleBeschikbareGerechten() {
        LijstGerechten event = new LijstGerechten(gerechtRepository.findAll());

        List<Gerecht> gerechten = new ArrayList<>();
        System.out.println("event: "+event.toString());
        for (int i = 0; i < event.getGerechten().size(); i++) {
            System.out.println("is dit true? "+event.getGerechten().get(i).getBeschikbaarheid());
            if(event.getGerechten().get(i).getBeschikbaarheid()){
                gerechten.add(event.getGerechten().get(i));
            }
        }
        System.out.println("gerechten naar bestelling: "+gerechten.toString());
        LijstGerechten gerechtenLijst = new LijstGerechten(gerechten);
        eventPublisher2.publishToBestelling(gerechtenLijst);


    }


    public void updateDatabase(List<Gerecht> gerechten) {

        for(int i = 0;i<gerechten.size();i++){

            gerechtRepository.save(gerechten.get(i));

        }
    }

}
