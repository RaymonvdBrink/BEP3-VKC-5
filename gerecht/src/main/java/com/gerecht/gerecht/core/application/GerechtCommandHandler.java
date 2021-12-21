package com.gerecht.gerecht.core.application;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.gerecht.gerecht.core.ports.storage.GerechtRepository;
import com.gerecht.gerecht.core.ports.storage.VoorraadRepository;
import com.voorraad.voorraad.core.domain.Voorraad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GerechtCommandHandler {
    private final GerechtRepository gerechtRepository;
    private final VoorraadRepository voorraadRepository;

    public GerechtCommandHandler(GerechtRepository gerechtRepository, VoorraadRepository voorraadRepository) {
        this.gerechtRepository = gerechtRepository;
        this.voorraadRepository = voorraadRepository;
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

    public List<Gerecht> geefAlleBeschikbareGerechten(){
        List<Gerecht>gerechten = new ArrayList<>();
       for (Voorraad voorraad: voorraadRepository.findAll() )
            if(voorraad.getItems().equals(0)){
                return IsnietBeschikbaar;
            }else {
                gerechten.add(gerecht);
            }

        return gerechtRepository.findAll();
    }

}
