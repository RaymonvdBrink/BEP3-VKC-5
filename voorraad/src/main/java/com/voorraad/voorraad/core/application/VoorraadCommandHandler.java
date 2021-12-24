package com.voorraad.voorraad.core.application;


import com.voorraad.voorraad.core.domain.Gerecht;
import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.core.port.storage.GerechtRepository;
import com.voorraad.voorraad.core.port.storage.VoorraadRepository;
import com.voorraad.voorraad.infrastructure.driven.messaging.RabbitMqEventPublisher;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechten;
import com.voorraad.voorraad.infrastructure.driver.web.dto.AlleGerechtenDTO;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtDTO;
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

    public boolean checkGerechtBeschikbaar(GerechtDTO gerecht){ // misschien heb je hier GerechtDTO nodig, moet je ff kijken wnr je de rabbitmq messages maakt
        boolean isbeschikbaar = true;
        Voorraad voorraad = voorraadRepository.findAll().get(0);
        // er hoort maar 1 voorraad te zijn dus pak je altijd 0 van findall, bij findbyid krijg je optional om een of andere reden en wordt alles rood
        for (int i = 0;i<gerecht.getIngredienten().size();i++){
            if(!isbeschikbaar){break;}
            for (int i2 = 0;i2<voorraad.getIngredienten().size();i2++){
                if (gerecht.getIngredienten().get(i).getNaam().equals(voorraad.getIngredienten().get(i2).getNaam())){
                    if(gerecht.getIngredienten().get(i).getAantal()>voorraad.getIngredienten().get(i2).getAantal()){
                        isbeschikbaar = false;
                        break;
                    }
                }
            }

        }
        return isbeschikbaar;
    }
    public List<Voorraad> findAll(){
        return voorraadRepository.findAll();
    }

    public List<GerechtDTO> updateBeschikbaarheidGerechten(List<GerechtDTO> gerechten){
        for (int i = 0;i<gerechten.size();i++){
            if(checkGerechtBeschikbaar(gerechten.get(i))){
                gerechten.get(i).setBeschikbaarheid(true);
            }else{
                gerechten.get(i).setBeschikbaarheid(false);
            }
            System.out.println("beschikbaarheid van "+gerechten.get(i).getNaam()+": "+gerechten.get(i).getBeschikbaarheid());
        }
        return gerechten;
    }

    public void sendMessage(List<GerechtDTO> event){
        rabbitMqEventPublisher.publish(event);
    }

//    public Voorraad getVoorraad(Long id){
//        return voorraadRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("voorraad bestaat niet"));
//    }

    public void updateIngredienten(AlleGerechtenDTO event){
        Voorraad voorraad = getVoorraad().get(0);
        for(int i =0;i<event.getGerechten().size();i++){
                for (int i2 =0;i2<event.getGerechten().get(i).getIngredienten().size();i2++){
                    for (int i3 =0;i3<voorraad.getIngredienten().size();i3++){
                        if(voorraad.getIngredienten().get(i3).getNaam().equals(event.getGerechten().get(i).getIngredienten().get(i2).getNaam())){
//                            System.out.println("aantal "+voorraad.getIngredienten().get(i3).getNaam()+"'s op voorraad voor de statement: "+voorraad.getIngredienten().get(i3).getAantal());
                            voorraad.getIngredienten().get(i3).setAantal(voorraad.getIngredienten().get(i3).getAantal() - event.getGerechten().get(i).getIngredienten().get(i2).getAantal());
//                            System.out.println("aantal "+voorraad.getIngredienten().get(i3).getNaam()+"'s op voorraad na de statement: "+voorraad.getIngredienten().get(i3).getAantal());
                        }
                    } // for loop om het aantal van een ingredient in database te verminderen wanneer het wordt gekocht
                }
        }
    voorraadRepository.save(voorraad);
    }
}




//    public void updateVoorraad(VoorraadEvent voorraad){
//        voorraad = new VoorraadEvent(voorraad.getEventId());
//        eventPublisher.publish(voorraad);
//    }

