package com.example.mapper;

import com.example.dto.user.UserRequest;
import com.example.dto.user.UserResponse;
import com.example.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserConverter extends BaseConverter<User, UserRequest, UserResponse>{

    @Override
    public User requestToEntity(UserRequest request){
        User entity = new User();
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        entity.setEmail(request.getEmail());
        return entity;
    }

    @Override
    public UserResponse entityToResponse(User entity){
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setEmail(entity.getEmail());
        response.setRole(entity.getRole());
        return response;
    }

    @Override
    public List<UserResponse> entityToResponse(List<User> entity) {
        return entity.stream().map(this::entityToResponse).toList();
    }
}
