package com.example.dao;

import com.example.entity.OrderItems;
import com.example.repository.OrderItemsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderItemsDAO {

    private final OrderItemsRepository orderItemsRepository;

    public OrderItemsDAO(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    //Save
    public OrderItems save(OrderItems orderItems) {
        return orderItemsRepository.save(orderItems);
    }
    //Find
    public Optional<OrderItems> findOrderItemsById(Integer id) {
        return orderItemsRepository.findById(id);
    }

    public List<OrderItems> findAllOrderItem() {
        return (List<OrderItems>) orderItemsRepository.findAll();
    }

    //Delete
    public void deleteOrderItemById(Integer id) {
        orderItemsRepository.deleteById(id);
    }
}
