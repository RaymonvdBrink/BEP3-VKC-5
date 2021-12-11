package com.registreren.registreren.user.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor @Data
public class ValidateDTO {

    @NonNull
    private String email;
}
