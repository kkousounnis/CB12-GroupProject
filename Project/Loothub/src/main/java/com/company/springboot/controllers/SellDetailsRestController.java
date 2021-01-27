/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.controllers;

import com.company.springboot.entities.ProductImage;
import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.SellDetailsDto;
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
    private UserService userService;


    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductImageService productImageService;

 

    @CrossOrigin("http://localhost:8080")
    @GetMapping("/getSellDetails")
    public List<SellDetailsDto> getAllSold(
            @CurrentSecurityContext(expression = "authentication?.name") String username) {

        User userSeller = new User();
        userSeller = userService.findByEmailAddress(username);
        List<SellDetailsDto> sellDetails = new ArrayList<>();

        for (ProductImage image : productImageService.listAll()) {
            if (userSeller.getId().equals(image.getUserId())) {
                if (ordersService.findByProductId(image.getProductId()) != null) {
                    if(ordersService.findByProductId(image.getProductId()).getItemStatusId().getStatus().equals("Sold") != true) {
                    sellDetails.add(new SellDetailsDto(image.getProductId().getName(),
                            image.getProductId().getPrice()
                            ));
                    }
                }
                else {
                    sellDetails.add(new SellDetailsDto(image.getProductId().getName(),
                            image.getProductId().getPrice()
                            ));
                }
            }
        }
        return (sellDetails);
    }
}
