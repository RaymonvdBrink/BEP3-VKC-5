package com.voorraad.voorraad.infrastructure.driver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor @Data @ToString
public class GerechtDTO {

    private String name;
    private int aantal;
    private Date vervaldatum;

}
