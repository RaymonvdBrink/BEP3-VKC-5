package com.voorraad.voorraad.core.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Voorraad")
@RequiredArgsConstructor
@Data
public class Voorraad {

    @Id
    private Long id;

    @NonNull
    private String naam;
    @NonNull
    private List<Gerecht> items = new ArrayList<>();


}
