package com.example.dto.orderitem;

import com.example.entity.Products;
import lombok.Data;

@Data

public class OrderItemRequest {

    private Integer productId;
    private Short quantity;


}
