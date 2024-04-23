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
    public Orders createOrders(Orders orders) {
        return ordersDAO.save(orders);
    }

    //Find
    public Optional<Orders> findOrdersById(Integer id) {
        return ordersDAO.findOrdersById(id);
    }

    public List<Orders> findAllOrders() {
        return  (List<Orders>) ordersDAO.findAllOrders();
    }

    //Update
    public Orders updateOrders(Orders orders) {
        return ordersDAO.save(orders);
    }

    //Delete
    public void deleteOrders(Integer id) {
        ordersDAO.deleteOrdersById(id);
    }

}
