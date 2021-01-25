package com.company.springboot.dao;

import com.company.springboot.entities.Role;
import com.company.springboot.repository.IRoleRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDao implements IRoleDao {
    
    @Autowired
    private IRoleRepository roleRepository;

    
    
    @Override
    public List<Role> listAll() {
        return roleRepository.findAll(); 
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role); 
    }

    @Override
    public Role get(Long id) {
        return roleRepository.findById(id).get(); 
    }

    @Override
    public void delete(Long id) {
        try {
        roleRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
           System.out.println("Role dao didnt find id to delete");
        }
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }
    
}
