package com.example.dao;

import com.example.entity.Products;
import com.example.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductsDAO {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsDAO(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //Create
    public Products createProduct(Products products) {
        return productsRepository.save(products);
    }

    //Find
    public Optional<Products> findProductById(Integer id) {
        return productsRepository.findById(id);
    }

    public List<Products> findAllProducts() {
        return (List<Products>) productsRepository.findAll();
    }

    //Update
    public Products updateProduct(Products products) {
        return productsRepository.save(products);
    }

    //Delete
    public void deleteProduct(Integer id) {
        productsRepository.deleteById(id);
    }
}
