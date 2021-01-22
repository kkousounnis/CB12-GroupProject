package com.company.springboot.dao;

import com.company.springboot.entities.Product;
import com.company.springboot.repository.IProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDao implements IProductDao {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> listAll() {
       return (productRepository.findAll());
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public Product productName(String name){
            Product product = productRepository.findByName(name);
        if (product == null) {
            //throw new UsernameNotFoundException("Invalid username or password.");
            return null;
        }
        return productRepository.findByName(name);
    }

}
