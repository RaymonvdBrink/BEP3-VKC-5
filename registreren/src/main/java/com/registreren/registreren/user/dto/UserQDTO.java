package com.registreren.registreren.user.dto;

import com.registreren.registreren.user.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class UserQDTO {

    private String id;
    private String firstName;
    private String lastName;
    private Address address;

}
