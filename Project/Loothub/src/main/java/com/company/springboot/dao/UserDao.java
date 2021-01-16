package com.company.springboot.dao;

import com.company.springboot.entities.Role;
import com.company.springboot.entities.User;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.company.springboot.repository.IUserRepository;
import java.util.List;

@Service
public class UserDao implements IUserDao {

    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDao(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        
//        User user = new User(registrationDto.getFirstName(),
//                registrationDto.getLastName(),
//                registrationDto.getEmail(),
//                passwordEncoder.encode(registrationDto.getPassword()),
//                Arrays.asList(new Role("ROLE_USER")),
//                registrationDto.getTelNumber());
        
        return userRepository.save(user);
    }
    
     
        
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        
        if (user == null) {
            //throw new UsernameNotFoundException("Invalid username or password.");
            return null;
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }
    
    public User findByEmailAddress(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User get(Long id) {
       return userRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    

}
