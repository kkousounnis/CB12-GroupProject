package com.company.springboot.controllers;

import com.company.springboot.entities.ContactNumber;
import com.company.springboot.entities.User;
import com.company.springboot.entities.UserAddress;
import com.company.springboot.entities.dto.ProfileDto;
import com.company.springboot.services.UserAddressService;
import com.company.springboot.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api"})
public class ProfileRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAddressService userAddressService;

    @CrossOrigin("http://localhost:8080")
    @GetMapping("/getProfileDetails")
    public ProfileDto getAllOrders(
            @CurrentSecurityContext(expression = "authentication?.name") String username) {

        ProfileDto profileDto = new ProfileDto();

        profileDto.setFirstName(userService.findByEmailAddress(username).getFirstName());
        profileDto.setLastName(userService.findByEmailAddress(username).getLastName());
        profileDto.setEmail(userService.findByEmailAddress(username).getEmail());

        profileDto.setTelNumber((List<ContactNumber>) userService.findByEmailAddress(username).getContactNumbers());

        profileDto.setUserAddress((List<UserAddress>) userService.findByEmailAddress(username).getUserAddressList());
        return (profileDto);
    }
    
    @DeleteMapping("/deleteAddress/{id}")
    public void deleteAddress(@PathVariable(value="id") int id)
    {
        UserAddress address = userAddressService.get(id);
        UserAddress userAddressNew = address;
        userAddressService.delete(userAddressNew.getId());
        
    }

}
