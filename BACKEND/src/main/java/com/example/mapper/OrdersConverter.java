package com.example.mapper;

import com.example.dto.order.OrderRequest;
import com.example.dto.order.OrderResponse;
import com.example.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersConverter extends BaseConverter<Orders, OrderRequest, OrderResponse>{

    @Override
    public Orders requestToEntity(OrderRequest request){
        Orders entity = new Orders();
        entity.setUser(request.getUser());
        entity.setOrderItems(request.getOrderItems());
        entity.setCreatedAt(request.getCreatedAt());
        return entity;
    }

    @Override
    public OrderResponse entityToResponse(Orders entity){
        OrderResponse response = new OrderResponse();
        response.setId(entity.getId());
        response.setUser(entity.getUser());
        response.setOrderItems(entity.getOrderItems());
        response.setTotal_amount(entity.getTotal_amount());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        return response;
    }

    @Override
    public List<OrderResponse> entityToResponse(List<Orders> enity){
        return enity.stream().map(this::entityToResponse).toList();
    }

    @Override
    public OrderResponse entityToResponse(Optional<Orders> optionalOrders){
        if (optionalOrders.isPresent()){
            Orders entity = optionalOrders.get();
            OrderResponse response = new OrderResponse();
            response.setId(entity.getId());
            response.setUser(entity.getUser());
            response.setOrderItems(entity.getOrderItems());
            response.setTotal_amount(entity.getTotal_amount());
            response.setStatus(entity.getStatus());
            response.setCreatedAt(entity.getCreatedAt());
            return response;

        }
        else {
            return null;
        }

    }
}
