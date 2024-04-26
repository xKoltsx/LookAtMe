package com.example.dto.order;

import com.example.dto.orderitem.OrderItemRequest;
import com.example.entity.OrderItems;
import com.example.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequest {
    private Integer userId;
    private List<OrderItemRequest> orderItems;
    private LocalDateTime createdAt;
}
