package com.voorraad.voorraad.infrastructure.driver.web;

import com.voorraad.voorraad.core.application.GerechtService;
import com.voorraad.voorraad.infrastructure.driver.web.dto.GerechtDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerecht")
@AllArgsConstructor
public class GerechtController {

    private final GerechtService gerechtService;

    @PostMapping("/create")
    public ResponseEntity<?> createGerecht(@RequestBody GerechtDTO gerechtDTO){
        try{
            gerechtService.saveGerecht(gerechtDTO);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGerecht(@RequestBody GerechtDTO gerechtDTO, @PathVariable String id){
        try{
            gerechtService.updateGerecht();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

}
