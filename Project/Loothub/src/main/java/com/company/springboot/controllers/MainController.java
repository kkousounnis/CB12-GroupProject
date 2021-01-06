package com.company.springboot.controllers;

import com.company.springboot.entities.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/loginsignup")
    public ModelAndView index_tmp() {
        
        ModelAndView modelAndView = new ModelAndView();
        UserRegistrationDto registrationDto = new UserRegistrationDto();
        modelAndView.addObject("userdto", registrationDto);
        modelAndView.setViewName("loginsignup");
        return modelAndView; 
    }
}
