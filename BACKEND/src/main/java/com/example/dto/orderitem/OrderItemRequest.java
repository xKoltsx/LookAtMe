package com.example.dto.orderitem;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Integer productId;
    private Short quantity;
}
