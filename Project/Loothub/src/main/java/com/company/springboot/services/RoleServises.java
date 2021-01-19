package com.company.springboot.services;

import com.company.springboot.dao.RoleDao;
import com.company.springboot.entities.Role;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleServises implements IRoleServises {
    
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> listAll() {
        return roleDao.listAll(); 
    }

    @Override
    public Role save(Role role) {
        return roleDao.save(role); 
    }

    @Override
    public Role get(Long id) {
        return roleDao.get(id); 
    }

    @Override
    public void delete(Long id) {
        try {
        roleDao.delete(id);
        } catch (EntityNotFoundException e) {
           System.out.println("Role Servises didnt find id to delete");
        }
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }
    
}
