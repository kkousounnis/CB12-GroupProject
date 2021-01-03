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
import com.company.springboot.entities.ContactNumber;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(IUserDao userdao) {
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

        User user = userDao.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");

        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

    @Override
    public List<User> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User get(Long id) {
       return userDao.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    

}
