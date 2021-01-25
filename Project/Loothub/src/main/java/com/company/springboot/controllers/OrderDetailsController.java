/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dim.Kasimatis
 */
@Controller
public class OrderDetailsController {

    @GetMapping("/orderDetails")
    public String orderDetails() {

        return ("orderDetails");
    }

}
