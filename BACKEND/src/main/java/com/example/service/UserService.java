package com.example.service;

import com.example.dao.UserDAO;
import com.example.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    //Create
    @Transactional
    public User createUser(User user){
        return userDAO.save(user);
    }

    //Find
    public Optional<User> findUserByid(Integer id){
        return userDAO.findUserById(id);
    }

    public List<User> findAllUsers(){
        return userDAO.findAllUsers();
    }

    //Update
    public User updateUser(User user){
        return userDAO.save(user);
    }

    //Delete
    public void deleteUser(Integer id){
        userDAO.deleteUserById(id);
    }
}
