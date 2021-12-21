package com.voorraad.voorraad.core.application;

import com.voorraad.voorraad.core.domain.Gerecht;
import com.voorraad.voorraad.core.port.storage.GerechtRepository;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GerechtService {

    @NonNull
    private final GerechtRepository gerechtRepository;

    public void saveGerecht(GerechtDTO gerechtDTO){
        gerechtRepository.save(new Gerecht(
                gerechtDTO.getName(),
                gerechtDTO.getAantal(),
                gerechtDTO.getVervaldatum()));
    }

    public void updateGerecht(){

    }
}
