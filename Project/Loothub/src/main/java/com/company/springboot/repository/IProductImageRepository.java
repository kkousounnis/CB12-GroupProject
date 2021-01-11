package com.company.springboot.repository;

import com.company.springboot.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductImageRepository extends JpaRepository<ProductImage, Integer>{

}
