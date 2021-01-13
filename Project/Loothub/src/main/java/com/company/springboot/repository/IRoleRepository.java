package com.company.springboot.repository;

import com.company.springboot.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository <Role,Long>{
    
}
