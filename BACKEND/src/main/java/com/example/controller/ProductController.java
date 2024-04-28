package com.example.controller;

import com.example.dto.product.ProductRequest;
import com.example.dto.product.ProductResponse;
import com.example.entity.Products;
import com.example.mapper.ProductsConverter;
import com.example.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")

public class ProductController {
    public final ProductsService productsService;
    public final ProductsConverter productsConverter;

    public ProductController(ProductsService productsService, ProductsConverter productsConverter) {
        this.productsService = productsService;
        this.productsConverter = productsConverter;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest productRequest){
        Products entity = productsConverter.requestToEntity(productRequest);
        entity = productsService.create(entity);
        ProductResponse response = productsConverter.entityToResponse(entity);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@PathVariable Integer id, @RequestBody ProductRequest productRequest){
        Products entity = productsService.findById(id);
        if (entity == null){
            return ResponseEntity.notFound().build();
        }
        Products updateEntity = productsConverter.requestToEntity(productRequest);
        updateEntity.setId(entity.getId());
        updateEntity = productsService.update(updateEntity);
        ProductResponse response = productsConverter.entityToResponse(updateEntity);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Iterable<ProductResponse>> get() {
        return ResponseEntity.ok(productsConverter.entityToResponse(productsService.findAll()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        productsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
