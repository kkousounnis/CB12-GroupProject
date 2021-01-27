package com.company.springboot.controllers;

import com.company.springboot.entities.ContactNumber;
import com.company.springboot.entities.UserAddress;
import com.company.springboot.entities.dto.ProfileDto;
import com.company.springboot.entities.dto.UserAddressDto;
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

        UserAddressDto userAddressDto = new UserAddressDto();

        setProfileDto(profileDto, username);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productDto", profileDto);
        modelAndView.addObject("userAddressDto", userAddressDto);
        modelAndView.setViewName("profile");
        return modelAndView;

    }

    @PostMapping("/editaddress")
    public ModelAndView editAddress(@ModelAttribute("userAddressDto") UserAddressDto userAddressDto,
            @ModelAttribute("productDto") ProfileDto profileDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();

        UserAddress userAddress = new UserAddress();
        setUserAddress(userAddress, username, userAddressDto);
        userAddressService.update(userAddress.getId(), userAddress);

        setProfileDto(profileDto, username);

        modelAndView.addObject("succesmessage", "Succesfull");
        modelAndView.addObject("productDto", profileDto);
        modelAndView.addObject("userAddressDto", userAddressDto);
        modelAndView.setViewName("profile");

        return modelAndView;
    }
    
    @PostMapping("/addaddress")
    public ModelAndView addAddress(@ModelAttribute("userAddressDto") UserAddressDto userAddressDto,
            @ModelAttribute("productDto") ProfileDto profileDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();

        UserAddress userAddress = new UserAddress();
        setUserAddress(userAddress, username, userAddressDto);

        userAddressService.save(userAddress);

        setProfileDto(profileDto, username);

        modelAndView.addObject("succesmessagenew", "Succesfull");
        modelAndView.addObject("productDto", profileDto);
        modelAndView.addObject("userAddressDto", userAddressDto);
        modelAndView.setViewName("profile");

        return modelAndView;
    }
    


    private void setUserAddress(UserAddress userAddress, String username, UserAddressDto userAddressDto) throws NumberFormatException {
        userAddress.setUserId(userService.findByEmailAddress(username));
        userAddress.setId(userAddressDto.getId());
        userAddress.setCountry(userAddressDto.getCountry());
        userAddress.setCity(userAddressDto.getCity());
        userAddress.setStreetName(userAddressDto.getStreetName());
        userAddress.setStreetNumber(userAddressDto.getStreetNumber());
        userAddress.setPostalCode(Integer.parseInt(userAddressDto.getPostalCode()));
    }

    private void setProfileDto(ProfileDto profileDto, String username) {
        profileDto.setFirstName(userService.findByEmailAddress(username).getFirstName());
        profileDto.setLastName(userService.findByEmailAddress(username).getLastName());
        profileDto.setEmail(userService.findByEmailAddress(username).getEmail());
        profileDto.setTelNumber((List<ContactNumber>) userService.findByEmailAddress(username).getContactNumbers());
        profileDto.setUserAddress((List<UserAddress>) userService.findByEmailAddress(username).getUserAddressList());
    }

}
