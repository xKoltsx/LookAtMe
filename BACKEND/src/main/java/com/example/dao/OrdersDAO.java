package com.example.dao;

import com.example.entity.Orders;
import com.example.repository.OrdersRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrdersDAO {

    private final OrdersRepository ordersRepository;

    public OrdersDAO(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    //Save
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }
    //Find
    public Optional<Orders> findById(Integer id) {
        return ordersRepository.findById(id);
    }

    public List<Orders> findAll() {
        return (List<Orders>) ordersRepository.findAll();
    }

    //Delete
    public void delete(Integer id) {
        ordersRepository.deleteById(id);
    }

}
