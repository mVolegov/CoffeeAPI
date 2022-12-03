package com.erp.Coffee.service;

import com.erp.Coffee.dto.UserOrderDTO;
import com.erp.Coffee.model.Order;

import java.util.List;

public interface OrderService {

    Order saveNewOrder(UserOrderDTO userOrderDTO);

    List<Order> findAllOrders();
}
