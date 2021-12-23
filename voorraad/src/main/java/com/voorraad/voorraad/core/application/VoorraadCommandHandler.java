package com.voorraad.voorraad.core.application;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.core.port.storage.GerechtRepository;
import com.voorraad.voorraad.core.port.storage.VoorraadRepository;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<Gerecht> geefAlleBeschikbareGerechten(List<Gerecht> gerechten){
        List<Gerecht> beschikbareGerechten = new ArrayList<>();
        for (int i = 0;i<gerechten.size();i++){
            if(checkGerechtBeschikbaar(gerechten.get(i))){
                beschikbareGerechten.add(gerechten.get(i));
            }
        }
        return beschikbareGerechten;
    }

}




//    public void updateVoorraad(VoorraadEvent voorraad){
//        voorraad = new VoorraadEvent(voorraad.getEventId());
//        eventPublisher.publish(voorraad);
//    }

