package com.erp.Coffee.restcontroller;

import com.erp.Coffee.dto.UserOrderDTO;
import com.erp.Coffee.model.Order;
import com.erp.Coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(@Qualifier("orderServiceImpl") OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> allOrders = orderService.findAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody UserOrderDTO userOrderDTO) {
        orderService.saveNewOrder(userOrderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
