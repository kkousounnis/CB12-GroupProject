
package com.company.springboot.services;

import com.company.springboot.entities.UserAddress;
import java.util.List;


public interface IUserAddressServise {
    
    public List<UserAddress> listAll();

    public UserAddress save(UserAddress useradress);

    public UserAddress get(int id);

    public void delete(int id);
    
    public void update(int id, UserAddress useradress);
}
    

