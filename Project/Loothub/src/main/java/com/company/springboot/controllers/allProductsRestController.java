package com.company.springboot.controllers;

import com.company.springboot.entities.Product;
import com.company.springboot.entities.dto.ProductDto;
import com.company.springboot.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api"})
public class allProductsRestController {

    @Autowired
    public ProductService productService;

    @CrossOrigin("http://localhost:8080")
    @GetMapping("/productList")
    public List<ProductDto> get() {
        List<Product> products = productService.listAll();
        
        List<ProductDto> listproductsDto = new ArrayList<>();
        ProductDto productDto = new ProductDto();

        Product product1 = new Product();
        int i = 0;
        for (Product product : products) {
            
            product1 = product;
            listproductsDto.add(new ProductDto(
                    product1.getName(),
                    product1.getPrice(),
                    product1.getCategory(),
                    product1.getDescription()
                    ));
        }
          System.out.println(products);
//        productDto.setCategory(product1.getCategory());
//        productDto.setDescription(product1.getDescription());
//        productDto.setName(product1.getName());
//        productDto.setPrice(product1.getPrice());

        return listproductsDto;
    }

}
