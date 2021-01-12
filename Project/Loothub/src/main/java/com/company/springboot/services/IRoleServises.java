package com.company.springboot.services;

import com.company.springboot.entities.Role;
import java.util.List;


public interface IRoleServises {
    public List<Role> listAll();
    public Role save(Role role);
    public Role get(Long id);
    public void delete(Long id);
    public void update(Role role);
    
}
