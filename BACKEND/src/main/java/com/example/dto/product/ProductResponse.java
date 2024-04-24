package com.example.dto.product;

import lombok.Data;

@Data
public class ProductResponse {
    private Integer id;
    private String name;
    private String price;
    private String description;
}
