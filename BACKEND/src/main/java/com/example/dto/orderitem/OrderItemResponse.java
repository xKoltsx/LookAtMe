package com.example.dto.orderitem;

import com.example.entity.Products;
import lombok.Data;

@Data
public class OrderItemResponse {
    private Integer id;
    private Products product;
    private Short quantity;

}
