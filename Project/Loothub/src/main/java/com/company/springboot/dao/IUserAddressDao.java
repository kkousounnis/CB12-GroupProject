
package com.company.springboot.dao;

import com.company.springboot.entities.UserAddress;
import java.util.List;


public interface IUserAddressDao {
    
    public List<UserAddress> listAll();

    public UserAddress save(UserAddress useradress);

    public UserAddress get(Long id);

    public void delete(Long id);
    
    public boolean update(UserAddress useradress);
}
    