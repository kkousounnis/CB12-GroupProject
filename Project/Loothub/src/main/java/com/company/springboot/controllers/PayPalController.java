package com.company.springboot.controllers;

import com.company.springboot.entities.dto.OrderDto;
import com.company.springboot.services.ItemStatusService;
import com.company.springboot.services.OrdersService;
import com.company.springboot.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PayPalController {
    
    @Autowired
    private ItemStatusService itemStatusService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private OrdersService ordersService;

    
    @PostMapping("/paypal")
    public ModelAndView orderProduct( @ModelAttribute("orderDto") OrderDto orderDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();
        
        System.out.println("%%%%%%%%%%%%"+username);
        
        System.out.println("%%%%%%%%%%%"+ordersService.findByUserId(userService.findByEmailAddress(orderDto.getEmail()).getId()));
        modelAndView.setViewName("loginsignup");
        
        return modelAndView;
    
    }

}
