package com.voorraad.voorraad.core.application;


import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.core.port.storage.VoorraadRepository;
import org.springframework.stereotype.Service;

@Service
public class VoorraadService {
    private final VoorraadRepository voorraadRepository;

    public VoorraadService(VoorraadRepository voorraadRepository) {
        this.voorraadRepository = voorraadRepository;
    }

    public void createVoorraad(Voorraad voorraad) {
        voorraadRepository.save(voorraad);
    }

    public void deleteVoorraad(String id) {
        voorraadRepository.deleteById(id);
    }
}
