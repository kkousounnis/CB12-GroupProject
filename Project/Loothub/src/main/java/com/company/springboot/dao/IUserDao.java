package com.company.springboot.dao;

import com.company.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Long>{
    User findByEmail(String email);
    
}
