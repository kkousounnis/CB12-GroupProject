package com.company.springboot.controllers;

import com.company.springboot.entities.ContactNumber;
import com.company.springboot.entities.UserAddress;
import com.company.springboot.entities.dto.OrderDto;
import com.company.springboot.services.UserAddressService;
import com.company.springboot.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/profile")
    public ModelAndView profileView(@CurrentSecurityContext(expression = "authentication?.name") String username) {

     
        OrderDto orderDto = new OrderDto();
        orderDto.setFirstName(userService.findByEmailAddress(username).getFirstName());
        orderDto.setLastName(userService.findByEmailAddress(username).getLastName());
        orderDto.setEmail(userService.findByEmailAddress(username).getEmail());
        orderDto.setTelNumber((List<ContactNumber>) userService.findByEmailAddress(username).getContactNumbers());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderDto", orderDto);
        modelAndView.setViewName("profile");
        return modelAndView;

    }

    @PostMapping("/edituser")
    public ModelAndView editUser(@ModelAttribute("orderDto") OrderDto orderDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();

        UserAddress userAddress = new UserAddress();
        userAddress.setCountry(orderDto.getCountry());
        userAddressService.save(userAddress);
        
        
        
        return modelAndView;
    }

}
