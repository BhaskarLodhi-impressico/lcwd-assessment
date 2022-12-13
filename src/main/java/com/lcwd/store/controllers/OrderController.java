package com.lcwd.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.store.dtos.CreateOrderRequest;
import com.lcwd.store.dtos.OrderDto;
import com.lcwd.store.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private String userId = "be5c94c1-cf87-4709-a07d-9f011a8afb41";

    // create
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(
            @RequestBody CreateOrderRequest createOrderData) {

        OrderDto createOrder = orderService.createOrder(createOrderData, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
    }
    
    @PutMapping("/cancel/{orderId}")
    public ResponseEntity<String> cancelOrderStatus(@PathVariable String orderId){
    	orderService.deleteOrder(orderId);
    	String message = "Order is cancelled with order id : " + orderId;
    	return ResponseEntity.ok(message);
    }
    
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
    	List<OrderDto> orders = orderService.getOrders();
    	return ResponseEntity.status(HttpStatus.FOUND).body(orders);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getOrdersByUserId(@PathVariable String userId){
    	List<OrderDto> orders = orderService.getOrdersOfUser(userId);
    	return ResponseEntity.status(HttpStatus.FOUND).body(orders);
    }
}
