package com.company.springboot.controllers;

import com.company.springboot.entities.ContactNumber;
import com.company.springboot.entities.UserAddress;
import com.company.springboot.entities.dto.OrderDto;
import com.company.springboot.entities.dto.ProfileDto;
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

     
        ProfileDto profileDto = new ProfileDto();

        profileDto.setFirstName(userService.findByEmailAddress(username).getFirstName());
        profileDto.setLastName(userService.findByEmailAddress(username).getLastName());
        profileDto.setEmail(userService.findByEmailAddress(username).getEmail());

        profileDto.setTelNumber((List<ContactNumber>) userService.findByEmailAddress(username).getContactNumbers());

        profileDto.setUserAddress((List<UserAddress>) userService.findByEmailAddress(username).getUserAddressList());
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productDto", profileDto);
        modelAndView.setViewName("profile");
        return modelAndView;

    }
//    @GetMapping("/profile")
//    public String profileView(@CurrentSecurityContext(expression = "authentication?.name") String username) {
//
//        return ("profile");
//    }

    @PostMapping("/edituser")
    public ModelAndView editUser(@ModelAttribute("orderDto") OrderDto orderDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();

        UserAddress userAddress = new UserAddress();

        userAddress.setUserId(userService.findByEmailAddress(username));
        userAddress.setCountry(orderDto.getCountry());
        userAddress.setCity(orderDto.getCity());
        userAddress.setStreetName(orderDto.getStreetName());
        userAddress.setStreetNumber(orderDto.getStreetNumber());
        userAddress.setPostalCode(Integer.parseInt(orderDto.getPostalCode()));

        userAddressService.save(userAddress);

        orderDto.setFirstName(userService.findByEmailAddress(username).getFirstName());
        orderDto.setLastName(userService.findByEmailAddress(username).getLastName());
        orderDto.setEmail(userService.findByEmailAddress(username).getEmail());
        orderDto.setTelNumber((List<ContactNumber>) userService.findByEmailAddress(username).getContactNumbers());
        orderDto.setCountry(userAddress.getCountry());
        orderDto.setCity(userAddress.getCity());
        orderDto.setStreetName(userAddress.getStreetName());
        orderDto.setStreetNumber(userAddress.getStreetNumber());
        orderDto.setPostalCode(Integer.toString(userAddress.getPostalCode()));
        modelAndView.addObject("orderDto", orderDto);
        modelAndView.addObject("succesmessage", "Succesfull");
        modelAndView.setViewName("profile");
        return modelAndView;
    }

}
