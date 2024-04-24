package com.example.mapper;

import com.example.dto.orderitem.OrderItemRequest;
import com.example.dto.orderitem.OrderItemResponse;
import com.example.entity.OrderItems;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemsConverter extends BaseConverter<OrderItems, OrderItemRequest, OrderItemResponse>{

    @Override
    public OrderItems requestToEntity(OrderItemRequest request){
        OrderItems entity = new OrderItems();
        entity.setProduct(request.getProduct());
        entity.setQuantity(request.getQuantity());
        return entity;
    }

    @Override
    public OrderItemResponse entityToResponse(OrderItems entity){
        OrderItemResponse response = new OrderItemResponse();
        response.setId(entity.getId());
        response.setProduct(entity.getProduct());
        response.setQuantity(entity.getQuantity());
        return response;
    }

    @Override
    public List<OrderItemResponse> entityToResponse(List<OrderItems> entity){
        return entity.stream().map(this::entityToResponse).toList();
    }

    @Override
    public OrderItemResponse entityToResponse(Optional<OrderItems> optionalOrderItems){
        if (optionalOrderItems.isPresent())
        {
            OrderItems entity = optionalOrderItems.get();
            OrderItemResponse response = new OrderItemResponse();
            response.setId(entity.getId());
            response.setProduct(entity.getProduct());
            response.setQuantity(entity.getQuantity());
            return response;
        }
        else{
            return null;
        }
    }
}
