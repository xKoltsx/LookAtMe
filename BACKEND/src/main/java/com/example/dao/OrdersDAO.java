package com.example.dao;

import com.example.entity.Orders;

import java.util.List;

public interface OrdersDAO {

    //Create
    void add(Orders orders);

    //Read
    List<Orders> getAll();
    Orders getById();

    //Update
    void update(Orders orders);

    //Delete
    void delete(Orders orders);
}
