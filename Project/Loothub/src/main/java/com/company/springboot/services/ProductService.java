package com.company.springboot.services;

import com.company.springboot.dao.ProductDao;
import com.company.springboot.entities.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService implements IProductService {
    
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }
    
    @Override
    public Product get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}