package com.example.repository;

import com.example.entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
}
