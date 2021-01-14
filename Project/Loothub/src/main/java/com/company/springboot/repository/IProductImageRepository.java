package com.company.springboot.repository;

import com.company.springboot.entities.Product;
import com.company.springboot.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, Integer>{
    ProductImage findByProductId(Product productId);
}
