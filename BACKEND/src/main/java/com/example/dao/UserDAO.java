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
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findByUsername(String username) { return (userRepository.findByUsername(username)); }
    //Delete
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
