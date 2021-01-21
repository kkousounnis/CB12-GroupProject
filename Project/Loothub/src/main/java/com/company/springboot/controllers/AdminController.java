package com.company.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
    
    @GetMapping("/admin/adminindex")
    public String home() {
        return "admin/adminindex";
    }
    
}
