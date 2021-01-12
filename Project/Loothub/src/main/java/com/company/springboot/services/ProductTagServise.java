package com.company.springboot.services;

import com.company.springboot.dao.ProductTagDao;
import com.company.springboot.entities.ProductTag;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductTagServise implements IProductTagServise {

    @Autowired
    private ProductTagDao productTagDao;
    
    @Override
    public List<ProductTag> listAll() {
        return productTagDao.listAll();
    }

    @Override
    public ProductTag save(ProductTag productTag) {
        return productTagDao.save(productTag);
    }

    @Override
    public ProductTag get(Long id) {
        return productTagDao.get(id);
    }

    @Override
    public void delete(Long id) {
        try {
        productTagDao.delete(id);
        } catch (EntityNotFoundException e) {
           System.out.println("productTagDao didnt find id to delete");
        }
    }

    @Override
    public void update(ProductTag productTag) {
        productTagDao.update(productTag);
    }
    
}
