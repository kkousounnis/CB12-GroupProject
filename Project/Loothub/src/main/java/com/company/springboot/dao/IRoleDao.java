package com.company.springboot.dao;

import com.company.springboot.entities.Role;
import java.util.List;


public interface IRoleDao {
    public List<Role> listAll();
    public Role save(Role role);
    public Role get(Long id);
    public void delete(Long id);
    public void update(Role role);
    
}
