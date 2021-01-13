package com.company.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    
    @GetMapping("/profile")
    public ModelAndView index_tmp() {
        
        ModelAndView modelAndView = new ModelAndView();
        //UserRegistrationDto registrationDto = new UserRegistrationDto();
        //modelAndView.addObject("userdto", registrationDto);
        modelAndView.setViewName("profile");
        return modelAndView; 
    }

}
