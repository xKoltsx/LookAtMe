package com.example.dto.user;

import com.example.entity.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Integer id;
    private String username;
    private String email;
    private Role role;
}
