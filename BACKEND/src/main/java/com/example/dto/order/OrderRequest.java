package com.example.dto.order;

import com.example.dto.orderitem.OrderItemRequest;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequest {
    private Integer userId;
    private List<OrderItemRequest> orderItems;
    private Float total_amount;
    private LocalDateTime createdAt;
}
