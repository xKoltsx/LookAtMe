package com.example.service;

import com.example.dao.ProductsDAO;
import com.example.entity.Products;


import com.example.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductsService {

    private final ProductsDAO productsDAO;

    @Autowired
    public ProductsService(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    //Create
    @Transactional
    public Products create(Products products) {
        return productsDAO.createProduct(products);
    }

    //Find

    public Products findById(Integer id){
        return productsDAO.findById(id).get();
    }

    public List<Products> findAll() {
        return  productsDAO.findAll();
    }

    //Update
    public Products update(Products products) {
        return productsDAO.update(products);
    }

    //Delete
    public void delete(Integer id) {
        productsDAO.delete(id);
    }
}
