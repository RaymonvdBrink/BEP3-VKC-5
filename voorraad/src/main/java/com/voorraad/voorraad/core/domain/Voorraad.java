package com.voorraad.voorraad.core.domain;

import com.gerecht.gerecht.core.domain.Gerecht;
import lombok.Data;
import lombok.Generated;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "Voorraad")
//@RequiredArgsConstructor
@Data
public class Voorraad {


    @MongoId
    private String id = "1";  // dit doe ik omdat er maar 1 voorraad mag zijn dus als je een 2e wil maken krijg je een error omdat ze hetzelfde ID hebben
                              // nog niet zeker of dit een goede aanpak is tho

//    @NonNull
    private String naam;
//    @NonNull
    private List<Ingredient> ingredienten = new ArrayList<>();

    public Voorraad(String naam, List<Ingredient> ingredienten) {
        this.naam = naam;
        this.ingredienten = ingredienten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Ingredient> getIngredienten() {
        return ingredienten;
    }

    public void setIngredienten(List<Ingredient> ingredienten) {
        this.ingredienten = ingredienten;
    }
//    public List<Gerecht> beschikbareGerechten(){
//        for(Gerecht g : items){
//            if(g != null){
//                items.add(g);
//            } else {
//                return null;
//            }
//        }
//        return null;
//    }


}
