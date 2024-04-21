package com.example.dao;

import com.example.entity.User;

import java.util.List;

public interface UserDAO {
    //Create
    void add(User user);

    //Read
    List<User> getAll();
    User getById(int id);

    //Update
    void update(User user);

    //Delete
    void delete(User user);
}
