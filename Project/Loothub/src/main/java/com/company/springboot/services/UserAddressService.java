package com.company.springboot.services;

import com.company.springboot.dao.UserAddressDao;
import com.company.springboot.entities.UserAddress;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserAddressService implements IUserAddressServise {
    
    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public List<UserAddress> listAll() {
        return userAddressDao.listAll(); 
    }

    @Override
    public UserAddress save(UserAddress userAddress) {
        return userAddressDao.save(userAddress); 
    }

    @Override
    public UserAddress get(int id) {
        return userAddressDao.get(id); 
    }

    @Override
    public void delete(int id) {
        try {
        userAddressDao.delete(id);
        } catch (EntityNotFoundException e) {
           System.out.println("useraddress didnt find id to delete");
        }

    }

    @Override
    public void update(int id, UserAddress userAddress) {
     userAddressDao.update(id, userAddress);
    }
    
}
