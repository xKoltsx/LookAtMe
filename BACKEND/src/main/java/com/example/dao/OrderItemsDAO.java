package com.example.dao;

import com.example.entity.OrderItems;

import java.util.List;

public interface OrderItemsDAO {

    //Create
    void add(OrderItems orderItems);

    //Read
    List<OrderItems> getAll();
    OrderItems getById(int id);

    //Update
    void update(OrderItems orderItems);

    //Delete
    void delete(OrderItems orderItems);
}
