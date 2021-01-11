package com.company.springboot.dao;

import com.company.springboot.entities.UserAddress;
import com.company.springboot.repository.IUserAddressRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressDao implements IUserAddressDao {
    
    @Autowired
    private IUserAddressRepository userAddressRepository;
            
    @Override
    public List<UserAddress> listAll() {
        return userAddressRepository.findAll(); 
    }

    @Override
    public UserAddress save(UserAddress userAddress) {
        return userAddressRepository.save(userAddress); 
    }

    @Override
    public UserAddress get(Long id) {
        return userAddressRepository.findById(id).get(); 
    }

    @Override
    public void delete(Long id) {
        try {
        userAddressRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
           System.out.println("useraddress didnt find id to delete");
        }
    }

    @Override
    public void update(UserAddress userAddress) {
        userAddressRepository.save(userAddress);
    }
    
}
