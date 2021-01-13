
package com.company.springboot.services;

import com.company.springboot.entities.UserAddress;
import java.util.List;


public interface IUserAddressServise {
    
    public List<UserAddress> listAll();

    public UserAddress save(UserAddress useradress);

    public UserAddress get(Long id);

    public void delete(Long id);
    
    public void update(UserAddress useradress);
}
    

