package com.example.service;

import com.example.dao.OrderItemsDAO;
import com.example.entity.OrderItems;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OrderItemsService {

    private final OrderItemsDAO orderItemsDAO;

    @Autowired
    public OrderItemsService(OrderItemsDAO orderItemsDAO) {
        this.orderItemsDAO = orderItemsDAO;
    }

    //Create
    @Transactional
    public OrderItems createOrderItem(OrderItems orderItems) {
        return orderItemsDAO.save(orderItems);
    }

    //Find
    public Optional<OrderItems> findOrderItemsByOrderById(Integer id) {
        return orderItemsDAO.findOrderItemsById(id);
    }

    public List<OrderItems> findOrderItemsAll() {
        return orderItemsDAO.findAllOrderItem();
    }

    //Update
    public OrderItems updateOrderItem(OrderItems orderItems) {
        return orderItemsDAO.save(orderItems);
    }

    //Delete
    public void deleteOrderItem(Integer id) {
        orderItemsDAO.deleteOrderItemById(id);
    }
}
