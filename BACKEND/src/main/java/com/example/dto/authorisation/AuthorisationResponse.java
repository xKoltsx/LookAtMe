package com.example.dto.authorisation;

import com.example.dto.user.UserResponse;
import lombok.Data;

@Data
public class AuthorisationResponse {
    private String role;
    private UserResponse user;
}
