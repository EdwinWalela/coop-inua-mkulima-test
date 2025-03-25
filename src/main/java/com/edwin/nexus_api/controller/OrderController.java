package com.edwin.nexus_api.controller;

import com.edwin.nexus_api.DTO.OrderDTO;
import com.edwin.nexus_api.DTO.OrderRequestDTO;
import com.edwin.nexus_api.model.Order;
import com.edwin.nexus_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO orderRequest){
        Order order = this.orderService.createOrder(orderRequest);
        return  ResponseEntity.ok(order);
    }

    @GetMapping("")
    public  ResponseEntity<List<OrderDTO>>  getAllOrders(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer limit
    ){
        List<OrderDTO> orders = this.orderService.getorders(page,limit);
        return ResponseEntity.ok(orders);
    }
}
