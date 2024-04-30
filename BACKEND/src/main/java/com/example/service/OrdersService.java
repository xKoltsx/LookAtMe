package com.example.service;

import com.example.dao.OrdersDAO;
import com.example.entity.Orders;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersDAO ordersDAO;

    @Autowired
    public OrdersService(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    //Create
    @Transactional
    public Orders create(Orders orders) {
        return ordersDAO.save(orders);
    }

    //Find
    public Optional<Orders> findById(Integer id) {
        return ordersDAO.findById(id);
    }

    public List<Orders> findAll() {
        return  (List<Orders>) ordersDAO.findAll();
    }

    //Update
    public Orders update(Orders orders) {
        return ordersDAO.save(orders);
    }

    //Delete
    public void delete(Integer id) {
        ordersDAO.delete(id);
    }

}
