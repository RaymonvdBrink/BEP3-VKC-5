package com.voorraad.voorraad.infrastructure;

import com.voorraad.voorraad.core.application.VoorraadCommandHandler;
import com.voorraad.voorraad.core.application.VoorraadService;
import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.infrastructure.driver.web.dto.VoorraadDTO;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/voorraad")
public class VoorraadController {

    private final VoorraadCommandHandler voorraadCommandHandler;

    public VoorraadController(VoorraadCommandHandler voorraadCommandHandler) {
        this.voorraadCommandHandler = voorraadCommandHandler;
    }


    @PostMapping("/create")
    public Voorraad createVoorraad(@RequestBody VoorraadDTO voorraadDTO){
        Voorraad voorraad = new Voorraad(voorraadDTO.getName());
        voorraadCommandHandler.createVoorraad(voorraad);
        return voorraad;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGerecht(@PathVariable String id){
        voorraadCommandHandler.deleteVoorraad(id);
    }


}
