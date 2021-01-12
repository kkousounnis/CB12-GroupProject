package com.company.springboot.repository;

import com.company.springboot.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders,Long>{
    
}
