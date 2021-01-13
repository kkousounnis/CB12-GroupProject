package com.company.springboot.controllers;

import com.company.springboot.entities.Product;
import com.company.springboot.entities.ProductImage;
import com.company.springboot.entities.dto.ProductDto;
import com.company.springboot.services.ProductImageService;
import com.company.springboot.services.ProductService;
import com.company.springboot.services.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    
    @Autowired 
    private ProductService productService;
    
    @Autowired 
    private ProductImageService productImageService;
    
    @Autowired 
    private UserService userservice;
   

    @GetMapping("/uploadproduct")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        ProductDto productDto = new ProductDto();
        modelAndView.addObject("productdto", productDto);
        modelAndView.setViewName("uploadproduct");
       
        return modelAndView;
    }

    @PostMapping("/uploadProduct")
    public ModelAndView uploadImage(@RequestParam("image") MultipartFile multipartFile,
            @ModelAttribute("productdto") ProductDto productDto, 
            Principal principal) throws IOException {
        
        System.out.println(principal.getName()+"Username");
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.addObject("productdto", productDto);
        modelAndView.setViewName("uploadproduct");        
        
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        
        System.out.println(userservice.findByEmailAddress("admin@gmail.com").getId()+"ti psaxnw egw");
        
        Path uploadPath = Paths.get("/tmp/images");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new IOException("Could not save upload file" + fileName);
        }
        

        
        Product product = new Product(
                productDto.getName(),
                productDto.getPrice(),
                productDto.getDescription(),
                productDto.getCategory()          
                );
       
       
        product=productService.save(product); 
        
        ProductImage productImage = new ProductImage(String.valueOf(uploadPath),
                product); 
        productImageService.save(productImage);
        
        

        return (modelAndView);
    }

}
