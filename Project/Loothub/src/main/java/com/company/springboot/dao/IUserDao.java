package com.company.springboot.dao;

import com.company.springboot.services.*;
import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.UserRegistrationDto;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserDao extends UserDetailsService{
    public List<User> listAll();
    public  User save(User user);
    public User get(int id);
    public void delete(int id);
}
