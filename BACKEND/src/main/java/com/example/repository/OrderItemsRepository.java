package com.example.repository;

import com.example.entity.OrderItems;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer> {
}
