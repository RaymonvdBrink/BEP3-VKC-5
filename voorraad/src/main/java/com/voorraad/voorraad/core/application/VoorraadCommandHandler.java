package com.voorraad.voorraad.core.application;

import com.voorraad.voorraad.core.domain.Gerecht;
import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.core.port.storage.GerechtRepository;
import com.voorraad.voorraad.core.port.storage.VoorraadRepository;
import com.voorraad.voorraad.infrastructure.driven.messaging.RabbitMqEventPublisher;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechten;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoorraadCommandHandler {
    private final VoorraadRepository voorraadRepository;
    private final GerechtRepository gerechtRepository;
    private final RabbitMqEventPublisher rabbitMqEventPublisher;


    public VoorraadCommandHandler(VoorraadRepository voorraadRepository, GerechtRepository gerechtRepository, RabbitMqEventPublisher rabbitMqEventPublisher) {
        this.voorraadRepository = voorraadRepository;
        this.gerechtRepository = gerechtRepository;
        this.rabbitMqEventPublisher = rabbitMqEventPublisher;
    }

    public void createVoorraad(Voorraad voorraad) {
        voorraadRepository.save(voorraad);
    }

    public void deleteVoorraad(Long id) {
        voorraadRepository.deleteById(id);
    }
    public List<Voorraad> getVoorraad(){
        return voorraadRepository.findAll();
    }

    public boolean checkGerechtBeschikbaar(Gerecht gerecht){ // misschien heb je hier GerechtDTO nodig, moet je ff kijken wnr je de rabbitmq messages maakt
        boolean isbeschikbaar = true;
        Voorraad voorraad = voorraadRepository.findAll().get(0);
        // er hoort maar 1 voorraad te zijn dus pak je altijd 0 van findall, bij findbyid krijg je optional om een of andere reden en wordt alles rood
        for (int i = 0;i<gerecht.getIngredienten().size();i++){
            for (int i2 = 0;i2<voorraad.getIngredienten().size();i2++){
                if (gerecht.getIngredienten().get(i).getNaam() == voorraad.getIngredienten().get(i2).getNaam()){
                    if(gerecht.getIngredienten().get(i).getAantal()>voorraad.getIngredienten().get(i2).getAantal()){
                        isbeschikbaar = false;
                    }
                }
            }
        }
        return isbeschikbaar;
    }


    public List<Gerecht> updateBeschikbaarheidGerechten(List<Gerecht> gerechten){

        for (int i = 0;i<gerechten.size();i++){
            if(checkGerechtBeschikbaar(gerechten.get(i))){
                gerechten.get(i).setBeschikbaarheid(true);
            }else{
                gerechten.get(i).setBeschikbaarheid(false);
            }
        }
        return gerechten;
    }

    public void sendMessage(AlleGerechten event){
        rabbitMqEventPublisher.publish(event);
    }

    public Voorraad getVoorrraad(Long id){
        return voorraadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("voorraad bestaat niet"));
    }

}




//    public void updateVoorraad(VoorraadEvent voorraad){
//        voorraad = new VoorraadEvent(voorraad.getEventId());
//        eventPublisher.publish(voorraad);
//    }

