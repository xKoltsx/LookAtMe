package com.example.service;

import com.example.dao.ProductsDAO;
import com.example.entity.Products;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
    public Optional<Products> findById(Integer id) {
        return productsDAO.findProductById(id);
    }

    public List<Products> findAll() {
        return  productsDAO.findAllProducts();
    }

    //Update
    public Products update(Products products) {
        return productsDAO.updateProduct(products);
    }

    //Delete
    public void delete(Integer id) {
        productsDAO.deleteProduct(id);
    }
}
