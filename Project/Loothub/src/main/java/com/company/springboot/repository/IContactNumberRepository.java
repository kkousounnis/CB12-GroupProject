package com.company.springboot.repository;

import com.company.springboot.entities.ContactNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactNumberRepository extends JpaRepository<ContactNumber,Long>  {
    
}
