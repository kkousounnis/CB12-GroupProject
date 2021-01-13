package com.company.springboot.controllers;

import com.company.springboot.entities.Product;
import com.company.springboot.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api"})
public class allProductsRestController {
    
    @Autowired
    public ProductService productService;
    
    @GetMapping("/productList")
    public List<Product> get(){
        List<Product> products = productService.listAll();
        for(Product product:products){
            System.out.println(product);
        }
        return productService.listAll();
    }

}
