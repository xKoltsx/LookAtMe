package com.example.dto.orderitem;

import com.example.dto.product.ProductResponse;
import com.example.entity.Products;
import lombok.Data;

@Data
public class OrderItemResponse {
    private Integer id;
    private ProductResponse product;
    private Short quantity;

}
