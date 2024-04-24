package com.example.dto.order;

import com.example.entity.OrderItems;
import com.example.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private Integer id;
    private User user;
    private List<OrderItems> orderItems;
    private Float total_amount;
    private String status;
    private LocalDateTime createdAt;
}
