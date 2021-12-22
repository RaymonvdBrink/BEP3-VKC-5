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
    private String id;

//    @NonNull
    private String naam;
//    @NonNull
    private List<Gerecht> items = new ArrayList<>();

    public Voorraad(String naam) {
        this.naam = naam;
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
