package com.company.springboot.controllers;

import com.company.springboot.entities.dto.UserRegistrationDto;
import com.company.springboot.services.UserService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ModelAndView registerUserAccount(@Valid @ModelAttribute("userdto") UserRegistrationDto registrationDto, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            
            modelAndView.setViewName("loginsignup");
            modelMap.addAttribute("bindingResult", bindingResult);
            modelMap.addAttribute("popupsignup", "popupsignup"); // we tell loginsignup page to keep modal open in order to show errors

        }else if(userService.loadUserByUsername(registrationDto.getEmail()) != null){
            modelMap.addAttribute("message", "Username already exists.");
            modelAndView.setViewName("loginsignup");
            modelMap.addAttribute("popupsignup", "popupsignup"); // we tell loginsignup page to keep modal open in order to show errors
        }        
        else {
            
            userService.save(registrationDto);
            modelAndView.setViewName("loginsignup");
            modelAndView.addObject("succesmessage", "Succesfull Sign Up");
            modelMap.addAttribute("popupsignup", "popupsignup"); // we tell loginsignup page to keep modal open in order to show errors
        }
        return modelAndView;
    }

}
