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

    @ModelAttribute("user")
    public UserRegistrationDto userRegistratioDto() {
        return new UserRegistrationDto();
    }

//    @GetMapping
//    public String showRegistrationForm(){
//        return "registration";  
//    }
    @GetMapping
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        UserRegistrationDto registrationDto = new UserRegistrationDto();
        modelAndView.addObject("user", registrationDto);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

//    @PostMapping
//    public String registerUserAccount(@Valid UserRegistrationDto registrationDto, BindingResult bindingResult){
//        userService.save(registrationDto);
//        return "redirect:/registration?success";    
//    }
    @PostMapping
    public ModelAndView registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto registrationDto, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
       
        if (bindingResult.hasErrors()) {
            
            modelAndView.setViewName("registration");
            modelMap.addAttribute("bindingResult", bindingResult);
            
        }else{
            userService.save(registrationDto);
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

}
