package com.example.dao;

import com.example.entity.Products;

import java.util.List;

public interface ProductsDAO {

    //Create
    void add(Products products);

    //Read
    List<Products> getAll();
    Products getById(int id);

    //Update
    void update(Products products);

    //Delete
    void delete(Products products);
}
