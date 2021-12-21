package com.voorraad.voorraad.infrastructure.driver.web;

import com.voorraad.voorraad.core.application.VoorraadService;
import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.infrastructure.driver.web.dto.VoorraadDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voorraad")
public class VoorraadController {

    private final VoorraadService voorraadService;

    public VoorraadController(VoorraadService voorraadService) {
        this.voorraadService = voorraadService;
    }


    @PostMapping("/create")
    public Voorraad createVoorraad(@RequestBody VoorraadDTO voorraadDTO){
        Voorraad voorraad = new Voorraad(voorraadDTO.getName());
        voorraadService.createVoorraad(voorraad);
        return voorraad;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVoorraad(@PathVariable String id){
        voorraadService.deleteVoorraad(id);
    }


}
