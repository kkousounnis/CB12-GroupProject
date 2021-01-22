/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.controllers;

import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.UserDto;
import com.company.springboot.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AllUserRestController {

    @Autowired
    public UserService userService;

    @CrossOrigin("http://localhost:8080")
    @GetMapping("/userList")
    public List<UserDto> get() {
        List<User> users = userService.listAll();

        List<UserDto> listusersDto = new ArrayList<>();
        UserDto userDto = new UserDto();

        User user1 = new User();
        int i = 0;
        for (User user : users) {
            user1 = user;
            listusersDto.add(new UserDto(
                    user1.getFirstName(),
                    user1.getLastName(),
                    user1.getEmail()
            ));
        }
        System.out.println(users);
        userDto.setFirstName(user1.getFirstName());
        userDto.setLastName(user1.getLastName());
        userDto.setEmail(user1.getEmail());

        return listusersDto;
    }

}

//    
//    public List<ProductDto> get() {
//        List<Product> products = productService.listAll();
//        
//        List<ProductDto> listproductsDto = new ArrayList<>();
//        ProductDto productDto = new ProductDto();
//
//        Product product1 = new Product();
//        int i = 0;
//        for (Product product : products) {
//            
//            product1 = product;
//            listproductsDto.add(new ProductDto(
//                    product1.getName(),
//                    product1.getPrice(),
//                    product1.getCategory(),
//                    product1.getDescription()
//                    ));
//        }
//          System.out.println(products);
//        productDto.setCategory(product1.getCategory());
//        productDto.setDescription(product1.getDescription());
//        productDto.setName(product1.getName());
//        productDto.setPrice(product1.getPrice());
//
//        return listproductsDto;

