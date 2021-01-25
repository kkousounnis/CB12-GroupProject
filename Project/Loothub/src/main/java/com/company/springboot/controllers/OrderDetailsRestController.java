package com.company.springboot.controllers;

import com.company.springboot.entities.Orders;
import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.OrderDetailsDto;
import com.company.springboot.entities.dto.OrderDto;
import com.company.springboot.services.OrdersService;
import com.company.springboot.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api"})
public class OrderDetailsRestController {

    @Autowired
    public OrdersService orderService;

    @Autowired
    private UserService userService;

    @CrossOrigin("http://localhost:8080")
    @GetMapping("/getOrderDetails")
    public List<OrderDetailsDto> getAllUsers(
            @CurrentSecurityContext(expression = "authentication?.name") String username) {

        User userBuyer = new User();
        userBuyer = userService.findByEmailAddress(username);
        List<OrderDetailsDto> ordersDetails = new ArrayList<>();

        for (Orders order : orderService.listAll()) {

            if (userBuyer.getId().equals(order.getUserId().getId())) {
                ordersDetails.add(new OrderDetailsDto(order.getId(),
                        order.getProductId().getName(),
                        order.getTrackingNumber(),
                        order.getBillingAddressId(),
                        order.getShippingAddressId(),
                        order.getProductId().getPrice()));
                System.out.println(order);
            }
        }

        return (ordersDetails);
    }

}
