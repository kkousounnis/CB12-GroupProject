package com.company.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellController {

    @GetMapping("/sellDetails")
    public String sellDetails() {

        return ("sellDetails");
    }

}
