package com.example.mapper;

import com.example.dto.product.ProductRequest;
import com.example.dto.product.ProductResponse;
import com.example.entity.Products;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductsConverter extends BaseConverter<Products, ProductRequest, ProductResponse>{

    @Override
    public Products requestToEntity(ProductRequest request){
        Products entity = new Products();
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setDescription(request.getDescription());
        return entity;
    }

    @Override
    public ProductResponse entityToResponse(Products entity){
         ProductResponse response = new ProductResponse();
         response.setId(entity.getId());
         response.setName(entity.getName());
         response.setPrice(entity.getPrice().toString());
         response.setDescription(entity.getDescription());
         return response;
    }

    @Override
    public List<ProductResponse> entityToResponse(List<Products> entity){
        return entity.stream().map(this::entityToResponse).toList();
    }

}
