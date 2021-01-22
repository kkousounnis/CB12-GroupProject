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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private UserService userService;

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

        Product product = new Product();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productdto", productDto);
        modelAndView.setViewName("uploadproduct");
        
        //Saving the image with user_id-fileName
        String fileName = userService.findByEmailAddress(principal.getName()).getId()+"-"+
                StringUtils.cleanPath(multipartFile.getOriginalFilename());
        
        //principal.getName is usrname value
        Path uploadPath = Paths.get("src/main/resources/static/img/products");
        
        saveProduct(uploadPath, multipartFile, fileName);

        product = productService.save(productDto);
        
        ProductImage productImage = new ProductImage(String.valueOf(uploadPath), 
                fileName,
                userService.findByEmailAddress(principal.getName()).getId(),
                product);
        productImageService.save(productImage);

        return (modelAndView);
    }
    
    @RequestMapping(value = {"/products"})
    //@RequestParam(defaultValue = "test") String id
    public ModelAndView showAllProducts(@RequestParam(value = "searchbar",required = false) String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        return modelAndView; 
    }  
    
//    @GetMapping(value = {"/products/{id}"})
//    public ModelAndView showAllProducts2() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("products");
//        return modelAndView; 
//    }  
    

    public void saveProduct(Path uploadPath, MultipartFile multipartFile, String fileName) throws IOException {

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new IOException("Could not save upload file" + fileName);
        }

    }

}
