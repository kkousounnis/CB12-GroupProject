/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.controllers;

import com.company.springboot.entities.ProductImage;
import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.SellDetailsDto;
import com.company.springboot.repository.IOrdersRepository;
import com.company.springboot.services.ItemStatusService;
import com.company.springboot.services.OrdersService;
import com.company.springboot.services.ProductImageService;
import com.company.springboot.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dim.Kasimatis
 */
@RestController
@RequestMapping(value = {"/api"})
public class SellDetailsRestController {

    @Autowired
    private OrdersService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemStatusService itemStatusService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private IOrdersRepository orderRepository;

    @CrossOrigin("http://localhost:8080")
    @GetMapping("/getSellDetails")
    public List<SellDetailsDto> getAllSells(
            @CurrentSecurityContext(expression = "authentication?.name") String username) {

        User userSeller = new User();
        userSeller = userService.findByEmailAddress(username);
        List<SellDetailsDto> sellDetails = new ArrayList<>();
        List<ProductImage> productImages = new ArrayList<>();

        for (ProductImage image : productImageService.listAll()) {
 System.out.println("first if JJJJJJ" + ordersService.findByProductId(image.getProductId()));
            if (userSeller.getId().equals(image.getUserId())) {
                System.out.println("first if KKKKKKK" + ordersService.findByProductId(image.getProductId()));
                if (ordersService.findByProductId(image.getProductId()) != null) {
                    System.out.println("second if MMMMMM");
                    sellDetails.add(new SellDetailsDto(image.getProductId().getName(),
                            ordersService.findByProductId(image.getProductId()).getTrackingNumber(),
                            ordersService.findByProductId(image.getProductId()).getShippingAddressId(),
                            ordersService.findByProductId(image.getProductId()).getBillingAddressId(),
                            image.getProductId().getPrice(),
                            ordersService.findByProductId(image.getProductId()).getItemStatusId().getStatus()));
                }
            }
        }
        return (sellDetails);
    }
}
