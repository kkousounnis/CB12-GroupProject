package com.company.springboot.repository;

import com.company.springboot.entities.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTagRepository extends JpaRepository<ProductTag,Long>{
    
}
