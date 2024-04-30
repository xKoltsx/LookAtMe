package com.example.controller;

import com.example.dto.order.OrderRequest;
import com.example.dto.order.OrderResponse;
import com.example.dto.orderitem.OrderItemRequest;
import com.example.entity.OrderItems;
import com.example.entity.Orders;
import com.example.mapper.OrderItemsConverter;
import com.example.mapper.OrdersConverter;
import com.example.service.OrderItemsService;
import com.example.service.OrdersService;
import com.example.service.ProductsService;
import com.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    private final OrdersConverter ordersConverter;
    private final OrdersService ordersService;
    private final UserService userService;
    private final OrderItemsService orderItemsService;
    private final OrderItemsConverter orderItemsConverter;
    private final ProductsService productsService;
    public OrderController(OrdersConverter ordersConverter, OrdersService ordersService, UserService userService, OrderItemsService orderItemsService, OrderItemsConverter orderItemsConverter, ProductsService productsService) {
        this.ordersConverter = ordersConverter;
        this.ordersService = ordersService;
        this.userService = userService;
        this.orderItemsService = orderItemsService;
        this.orderItemsConverter = orderItemsConverter;
        this.productsService = productsService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> save(@RequestBody OrderRequest orderRequest){
        Orders entity = ordersConverter.requestToEntity(orderRequest);
        entity.setUser(userService.findByid(orderRequest.getUserId()));

        List<OrderItemRequest> orderItemRequests = orderRequest.getOrderItems();
        List<OrderItems> orderItemsList = new ArrayList<>();

        for (OrderItemRequest orderItemRequest : orderItemRequests) {
            OrderItems orderItem = orderItemsConverter.requestToEntity(orderItemRequest);
            orderItem.setProduct(productsService.findById(orderItemRequest.getProductId()));
            orderItemsList.add(orderItem);
        }

        entity.setOrderItems(orderItemsList);
        //entity = ordersService.createOrders(entity);
        OrderResponse response = ordersConverter.entityToResponse(entity);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        ordersService.delete(id);
        return ResponseEntity.ok().build();
    }



}
