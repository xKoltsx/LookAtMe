package com.example.dto.product;

import lombok.Data;

@Data
public class ProductResponse {
    private Integer id;
    private String name;
    private Integer price;
    private String description;
}
