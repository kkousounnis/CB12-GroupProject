package com.company.springboot.controllers;

import com.company.springboot.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @RequestMapping("/order/{id}")
    public ModelAndView showOrder(@PathVariable Integer id, @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("example", "Leonardo Da vinci");
        System.out.println(username + "me lene karam");
        //System.out.println(principal.getName()+"melenemakaro");
        //ProductDto productDto = new ProductDto();
        //modelAndView.addObject("productdto", productDto);
        modelAndView.setViewName("order");

        return modelAndView;
    }

}
