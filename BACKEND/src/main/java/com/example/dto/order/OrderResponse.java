package com.example.dto.order;

import com.example.dto.orderitem.OrderItemResponse;
import com.example.dto.user.UserResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private Integer id;
    private UserResponse user;
    private List<OrderItemResponse> orderItems;
    private Float total_amount;
    private String status;
    private LocalDateTime createdAt;
}
