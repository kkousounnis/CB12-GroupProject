package com.company.springboot.controllers;

import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.OrderDto;
import com.company.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @Autowired
    private UserService userService;

    @RequestMapping("/order/{id}")
    public ModelAndView showOrder(@PathVariable Integer id, @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();
        OrderDto orderDto = new OrderDto();
        modelAndView.addObject("orderDto", orderDto);

        if (username.equals("anonymousUser")) {
            User user = new User();
            modelAndView.addObject("user", user);

        } else {
            modelAndView.addObject("user", userService.findByEmailAddress(username));
        }

        modelAndView.addObject("example", "Leonardo Da vinci");
        System.out.println(username + "me lene karam");
       

        modelAndView.setViewName("order");

        return modelAndView;
    }

    @PostMapping("/order")
    public ModelAndView uploadImage(@ModelAttribute("orderDto") OrderDto orderDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(orderDto.getCountry() + "me lene gewrgio");
        modelAndView.setViewName("dummyPage");
        return modelAndView;
    }

}
