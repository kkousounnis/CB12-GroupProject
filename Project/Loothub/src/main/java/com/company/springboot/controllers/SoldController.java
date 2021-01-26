package com.company.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SoldController {

    @GetMapping("/soldDetails")
    public String soldDetails() {

        return ("soldDetails");
    }

}
