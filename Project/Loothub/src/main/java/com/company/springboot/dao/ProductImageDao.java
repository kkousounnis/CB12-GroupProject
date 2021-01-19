package com.company.springboot.dao;

import com.company.springboot.entities.Product;
import com.company.springboot.services.*;
import com.company.springboot.entities.ProductImage;
import com.company.springboot.repository.IProductImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageDao implements IProductImageService {
    
    @Autowired
    private IProductImageRepository productImageRepository;

    

    @Override
    public List<ProductImage> listAll() {
        return (productImageRepository.findAll());
    }

    @Override
    public ProductImage save(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImage get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ProductImage findByProductId(Product productId){
        return productImageRepository.findByProductId(productId);
    }

}
