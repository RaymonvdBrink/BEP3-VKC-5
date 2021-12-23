package com.voorraad.voorraad.core.application;


import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.core.port.storage.VoorraadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoorraadService {
    private final VoorraadRepository voorraadRepository;

    public VoorraadService(VoorraadRepository voorraadRepository) {
        this.voorraadRepository = voorraadRepository;
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
}
