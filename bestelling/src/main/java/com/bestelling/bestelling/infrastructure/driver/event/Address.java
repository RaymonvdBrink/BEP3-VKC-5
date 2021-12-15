package com.bestelling.bestelling.infrastructure.driver.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Address {

    private String city;
    private String postcode;
    private String street;
    private int houseNumber;

}
