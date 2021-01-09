package com.company.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {
    
    @GetMapping("/uploadproduct")
    public String home() {
        return "uploadproduct";
    }

}
