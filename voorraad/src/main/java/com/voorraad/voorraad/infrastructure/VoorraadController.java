package com.voorraad.voorraad.infrastructure;

import com.gerecht.gerecht.core.domain.Gerecht;
import com.voorraad.voorraad.core.application.VoorraadCommandHandler;
import com.voorraad.voorraad.core.domain.Voorraad;
import com.voorraad.voorraad.core.port.storage.GerechtRepository;
import com.voorraad.voorraad.infrastructure.driver.web.dto.VoorraadDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voorraad")
public class VoorraadController {

    private final VoorraadCommandHandler voorraadCommandHandler;
    private final GerechtRepository gerechtRepository;

    public VoorraadController(VoorraadCommandHandler voorraadCommandHandler, GerechtRepository gerechtRepository) {
        this.voorraadCommandHandler = voorraadCommandHandler;
        this.gerechtRepository = gerechtRepository;
    }
    @GetMapping("/getAll")
    public List<Gerecht> geefGerechten(){
        return gerechtRepository.findAll();

    }


    @PostMapping("/create")
    public Voorraad createVoorraad(@RequestBody VoorraadDTO voorraadDTO){
        Voorraad voorraad = new Voorraad(voorraadDTO.getName(), voorraadDTO.getIngredients());
        voorraadCommandHandler.createVoorraad(voorraad);
        return voorraad;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGerecht(@PathVariable String id){
        voorraadCommandHandler.deleteVoorraad(id);
    }


}
