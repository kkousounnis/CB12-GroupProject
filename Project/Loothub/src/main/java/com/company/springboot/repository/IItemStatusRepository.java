package com.company.springboot.repository;

import com.company.springboot.entities.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemStatusRepository extends JpaRepository<ItemStatus,Long> {
    
}
