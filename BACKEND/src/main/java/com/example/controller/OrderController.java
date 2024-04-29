package com.example.controller;

import com.example.dto.order.OrderRequest;
import com.example.dto.order.OrderResponse;
import com.example.dto.orderitem.OrderItemRequest;
import com.example.dto.orderitem.OrderItemResponse;
import com.example.dto.product.ProductRequest;
import com.example.dto.product.ProductResponse;
import com.example.entity.OrderItems;
import com.example.entity.Orders;
import com.example.entity.Products;
import com.example.mapper.OrderItemsConverter;
import com.example.mapper.OrdersConverter;
import com.example.service.OrderItemsService;
import com.example.service.OrdersService;
import com.example.service.ProductsService;
import com.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
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
            orderItem = orderItemsService.createOrderItem(orderItem);
            orderItemsList.add(orderItem);
        }

        entity.setOrderItems(orderItemsList);
        entity = ordersService.createOrders(entity);

        // Convert List<OrderItems> to List<OrderItemResponse>
        List<OrderItemResponse> orderItemResponses = orderItemsList.stream()
                .map(orderItemsConverter::entityToResponse)
                .toList();

        OrderResponse response = ordersConverter.entityToResponse(entity);
        response.setOrderItems(orderItemResponses);

        return ResponseEntity.ok(response);
    }


    //@PutMapping
    //public ResponseEntity<OrderResponse> update(@PathVariable Integer id, @RequestBody OrderRequest orderRequest){
    //    Orders entity = ordersService.findOrdersById(id);
    //    if (entity == null){
   //         return ResponseEntity.notFound().build();
    //    }
   //     Orders updateEntity = ordersConverter.requestToEntity(orderRequest);
   //     updateEntity.setId(entity.getId());
   // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Orders entity = ordersService.findOrdersById(id);
        List<OrderItems> orderItemsList = entity.getOrderItems();
        for(OrderItems orderItems : orderItemsList){
            OrderItems temp = orderItemsService.findOrderItemsByOrderById(orderItems.getId());
            orderItemsService.delete(temp.getId());
        }
        ordersService.delete(id);
        return ResponseEntity.ok().build();
    }
}
