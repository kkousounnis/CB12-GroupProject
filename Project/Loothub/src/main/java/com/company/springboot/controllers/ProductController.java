package com.company.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductController {
    
    @GetMapping("/uploadproduct")
    public String home() {
        return "uploadproduct";
    }
    
    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        
        Path uploadPath = Paths.get("/tmp/img");
        
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
         
        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        
        }catch(IOException e){
            throw new IOException("Could not save upload file"+fileName);
        }
       
        
        return ("uploadproduct");
    }

}
