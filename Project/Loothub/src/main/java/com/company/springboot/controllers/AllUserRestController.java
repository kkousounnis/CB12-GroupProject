/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.controllers;

import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.UserDto;
import com.company.springboot.repository.IUserRepository;
import com.company.springboot.services.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dim.Kasimatis
 */
@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = {"/api"})
public class AllUserRestController {

    @Autowired
    public UserService userService;
    
    @Autowired
    public IUserRepository userRepository;
    
    @CrossOrigin("http://localhost:8080")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        
        return userRepository.findAll();
    }
    
    @GetMapping("getUserById/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<User> getUserById(@PathVariable(value="id") int id) {
        return userRepository.findById(id);
    }
    
    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(@PathVariable(value="id") int id)
    {
        Optional<User> user = userRepository.findById(id);
        User userNew = user.get();
        userRepository.delete(userNew);
        
    }

}


