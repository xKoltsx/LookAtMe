package com.example.dao;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {

    private final UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Save
    public User save(User user) {
        return userRepository.save(user);
    }
    //Find
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    //Delete
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
