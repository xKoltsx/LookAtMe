package com.example.dao;

import com.example.entity.User;
import com.example.repository.PrimaryRepository;

public class UserDAO extends AbstractDao<User>{
    @Override
    protected PrimaryRepository<Integer, User> getRepository() {
        return null;
    }
}
