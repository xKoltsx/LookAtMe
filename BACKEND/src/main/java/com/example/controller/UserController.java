package com.example.controller;


import com.example.dto.user.UserRequest;
import com.example.dto.user.UserResponse;
import com.example.entity.Role;
import com.example.entity.User;

import com.example.mapper.UserConverter;
import com.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController{

    private final UserService userService;
    private final UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        User entity = userConverter.requestToEntity(request);
        entity.setRole(Role.ROLE_USER);
        entity = userService.createUser(entity);
        UserResponse response = userConverter.entityToResponse(entity);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Integer id, @RequestBody UserRequest request){
        User entity = userService.findByid(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        User updateEntity = userConverter.requestToEntity(request);
        updateEntity.setId(entity.getId());
        updateEntity.setRole(entity.getRole());
        updateEntity = userService.updateUser(updateEntity);
        UserResponse response = userConverter.entityToResponse(updateEntity);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Iterable<UserResponse>> getAll() {
        return ResponseEntity.ok(userConverter.entityToResponse(userService.findAllUsers()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
