package com.bestelling.bestelling.infrastructure.driver.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class UserDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Address adres;

    public String getEmail() {
        return email;
    }
}