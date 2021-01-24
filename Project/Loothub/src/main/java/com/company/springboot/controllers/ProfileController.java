package com.company.springboot.controllers;

import com.company.springboot.entities.ContactNumber;
import com.company.springboot.entities.UserAddress;
import com.company.springboot.entities.dto.AddressDto;
import com.company.springboot.entities.dto.ContactNumberDto;
import com.company.springboot.entities.dto.UserDto;
import com.company.springboot.entities.dto.UserProfileDto;
import com.company.springboot.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ModelAndView profileView(@CurrentSecurityContext(expression = "authentication?.name") String username) {

        
        UserProfileDto profileDto = new UserProfileDto();
        
        profileDto.setUserDto(new UserDto(userService.findByEmailAddress(username).getFirstName(), 
                userService.findByEmailAddress(username).getLastName(),
                userService.findByEmailAddress(username).getEmail()));
        
        profileDto.setContactDto(new ContactNumberDto((List<ContactNumber>) userService.findByEmailAddress(username).getContactNumbers()));
        
        profileDto.setAddressDto(new AddressDto((List<UserAddress>) userService.findByEmailAddress(username).getUserAddressList()));
        
        System.out.println(profileDto.getContactDto().getTelNumber().get(0) + "***HELLOOOOO");
        
        
//        OrderDto orderDto = new OrderDto();
//        orderDto.setFirstName(userService.findByEmailAddress(username).getFirstName());
//        orderDto.setLastName(userService.findByEmailAddress(username).getLastName());
//        orderDto.setEmail(userService.findByEmailAddress(username).getEmail());
//        orderDto.setTelNumber((List<ContactNumber>) userService.findByEmailAddress(username).getContactNumbers());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("profileDto", profileDto);
        modelAndView.setViewName("profile");
        return modelAndView;
    }

}
