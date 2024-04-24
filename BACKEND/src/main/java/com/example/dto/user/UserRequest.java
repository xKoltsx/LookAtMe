package com.example.dto.user;

import com.example.entity.Role;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private Role role;
}
