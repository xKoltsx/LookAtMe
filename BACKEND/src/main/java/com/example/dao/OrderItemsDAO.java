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

    public List<OrderItems> saveAll(List<OrderItems> orderItemsList) {
        return (List<OrderItems>) orderItemsRepository.saveAll(orderItemsList);
    }

    //Find
    public Optional<OrderItems> findById(Integer id) {
        return orderItemsRepository.findById(id);
    }

    public List<OrderItems> findAll() {
        return (List<OrderItems>) orderItemsRepository.findAll();
    }

    //Delete
    public void delete(Integer id) {
        orderItemsRepository.deleteById(id);
    }
}
