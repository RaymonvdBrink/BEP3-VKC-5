package com.voorraad.voorraad.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@RequiredArgsConstructor
@Data
@Document(collection = "Gerecht")
public class Gerecht {

    @MongoId
    public String id;

    @NonNull
    private String name;
    @NonNull
    private int aantal;
    @NonNull
    private Date vervaldatum;

}
