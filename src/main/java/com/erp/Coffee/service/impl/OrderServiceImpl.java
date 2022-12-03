package com.erp.Coffee.service.impl;

import com.erp.Coffee.dto.UserOrderDTO;
import com.erp.Coffee.model.Order;
import com.erp.Coffee.model.OrderComposition;
import com.erp.Coffee.repository.MenuItemRepository;
import com.erp.Coffee.repository.OrderCompositionRepository;
import com.erp.Coffee.repository.OrderRepository;
import com.erp.Coffee.repository.UserRepository;
import com.erp.Coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MenuItemRepository menuItemRepository;

    private final OrderCompositionRepository orderCompositionRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository,
                            MenuItemRepository menuItemRepository,
                            OrderCompositionRepository orderCompositionRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.menuItemRepository = menuItemRepository;
        this.orderCompositionRepository = orderCompositionRepository;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveNewOrder(UserOrderDTO userOrderDTO) {
        Order order = saveOrder(userOrderDTO);

        Map<Long, Integer> cart = userOrderDTO.getCart();
        List<OrderComposition> menuItemsInOrder = new ArrayList<>();
        cart.forEach((key, value) -> menuItemsInOrder.add(new OrderComposition(menuItemRepository.findMenuItemById(key), value, order)));

        orderCompositionRepository.saveAll(menuItemsInOrder);

        order.setMenuItemsInOrder(menuItemsInOrder);

        System.out.println("АЙДИШНИК: " + order.getId());

        return orderRepository.save(order);
    }

    private Order saveOrder(UserOrderDTO userOrderDTO) {
        String username = userOrderDTO.getUsername();

        Order orderToSave = new Order();
        orderToSave.setUser(userRepository.findByUsername(username).get());
        orderToSave.setCreatedDate(new Date());
        orderToSave.setStatus("DONE");

        return orderRepository.save(orderToSave);
    }
}
