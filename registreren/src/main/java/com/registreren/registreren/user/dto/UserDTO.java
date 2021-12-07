package com.registreren.registreren.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class UserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

}
