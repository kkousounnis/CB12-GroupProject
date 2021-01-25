package com.company.springboot.controllers;

import com.company.springboot.entities.Product;
import com.company.springboot.entities.ProductImage;
import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.ProductDto;
import com.company.springboot.entities.dto.ProductImagePathDto;
import com.company.springboot.repository.IProductRepository;
import com.company.springboot.services.ProductImageService;
import com.company.springboot.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api"})
public class ΑllProductsRestController {
    
    @Autowired
    public IProductRepository productRepository;

    @Autowired
    public ProductService productService;

    @Autowired
    public ProductImageService productImageService;

    @CrossOrigin("http://localhost:8080")
    @GetMapping("/productList")
    public List<ProductImagePathDto> get() {
        List<Product> products = productService.listAll();

        List<ProductImagePathDto> listproductsImagePathDto = new ArrayList<>();

        ProductDto productDto = new ProductDto();
        ProductImage productImagePath = new ProductImage();

        Product product1 = new Product();
        int i = 0;
        for (Product product : products) {

            product1 = product;

            productImagePath = productImageService.findByProductId(product1);

            listproductsImagePathDto.add(new ProductImagePathDto(
                    product1.getId(),
                    product1.getName(),
                    product1.getPrice(),
                    product1.getDescription(),
                    product1.getCategory(),
                    productImagePath.getId(),
                    productImagePath.getImagePath(),
                    productImagePath.getFileName(),
                    productImagePath.getUserId()
            ));
        }
        System.out.println(listproductsImagePathDto);

        return listproductsImagePathDto;
    }
    
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable(value="id") int id)
    {
        Optional<Product> product = productRepository.findById(id);
        Product productNew = product.get();
        productRepository.delete(productNew);
        
    }

}
