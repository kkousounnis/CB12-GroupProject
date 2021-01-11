package com.company.springboot.services;

import com.company.springboot.dao.ProductImageDao;
import com.company.springboot.entities.ProductImage;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductImageService implements IProductImageService {
    
    @Autowired
    private ProductImageDao productImageDao;

    @Override
    public List<ProductImage> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductImage save(ProductImage productImage) {
        return productImageDao.save(productImage);
    }

    @Override
    public ProductImage get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
