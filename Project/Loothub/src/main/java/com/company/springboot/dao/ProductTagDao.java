package com.company.springboot.dao;

import com.company.springboot.entities.ProductTag;
import com.company.springboot.repository.IProductTagRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTagDao implements IProductTagDao {
    
    @Autowired
    private IProductTagRepository productTagRepository;

    @Override
    public List<ProductTag> listAll() {
        return productTagRepository.findAll();
    }

    @Override
    public ProductTag save(ProductTag productTag) {
        return productTagRepository.save(productTag);
    }

    @Override
    public ProductTag get(Long id) {
        return productTagRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        try {
        productTagRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
           System.out.println("productTagRepository didnt find id to delete");
        }
    }

    @Override
    public void update(ProductTag productTag) {
        productTagRepository.save(productTag);
    }
    
}
