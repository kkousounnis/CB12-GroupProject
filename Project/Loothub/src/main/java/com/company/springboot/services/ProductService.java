package com.company.springboot.services;

import com.company.springboot.dao.ProductDao;
import com.company.springboot.entities.Product;
import com.company.springboot.entities.ProductImage;
import com.company.springboot.entities.dto.ProductDto;
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
       return (productDao.listAll());
    }

    @Override
    public Product save(ProductDto productDto) {
        Product product = new Product(
                productDto.getName(),
                productDto.getPrice(),
                productDto.getDescription(),
                productDto.getCategory()
        );
        
        return productDao.save(product);
    }
    
        public Product findByProductName(String name){
        return productDao.productName(name);
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
