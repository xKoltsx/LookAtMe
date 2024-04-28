package com.example.dto.authorisation;

import lombok.Data;

@Data
public class AuthorisationRequest {
    private String username;
    private String password;
}
