package com.company.springboot.services;

import com.company.springboot.entities.Role;
import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.UserRegistrationDto;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.company.springboot.dao.IUserDao;
import com.company.springboot.dao.UserDao;
import java.util.List;

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

//        User user = new User(registrationDto.getFirstName(),
//                registrationDto.getLastName(),
//                registrationDto.getEmail(),
//                passwordEncoder.encode(registrationDto.getPassword()),
//                Arrays.asList(new Role("ROLE_USER")),
//                registrationDto.getTelNumber());
        return userDao.save(registrationDto);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userDao.loadUserByUsername(username);

    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public List<User> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
