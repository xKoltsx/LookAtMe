package com.example.controller;

import com.example.dto.authorisation.AuthorisationRequest;
import com.example.dto.user.UserResponse;
import com.example.entity.User;
import com.example.mapper.UserConverter;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthorisationController {
    private final UserService userService;
    private final UserConverter userConverter;


    public AuthorisationController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody AuthorisationRequest request){
        User user = userService.findByUsername(request.getUsername());
        if (user != null) {
            UserResponse response = userConverter.entityToResponse(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }




}
