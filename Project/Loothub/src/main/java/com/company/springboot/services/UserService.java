package com.company.springboot.services;

import com.company.springboot.entities.Role;
import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.UserRegistrationDto;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.company.springboot.dao.UserDao;
import java.util.List;
import java.util.Optional;
import com.company.springboot.exceptions.UserNotFoundException;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public UserService(UserDao userdao) {
        this.userDao = userdao;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {

        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_USER")),
                registrationDto.getTelNumber());
        return userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.loadUserByUsername(username);
    }
    
    public User findByEmailAddress(String email){
        return userDao.findByEmailAddress(email);
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> listAll() {
       return userDao.listAll();
    }
    
    public Optional<User> findById(int id) {
        return userDao.findbyId(id);
    }

    
     public void updateResetPasswordToken(String token, String email) throws UserNotFoundException{
        User user = userDao.findByEmailAddress(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userDao.save(user);
        } else {
             throw new UserNotFoundException("Could not find any customer with the email " + email);
        }
    }
     
    public User getByResetPasswordToken(String token) {
        return userDao.findByResetPasswordToken(token);
    }
     
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
         
        user.setResetPasswordToken(null);
        userDao.save(user);
    }

  
}
