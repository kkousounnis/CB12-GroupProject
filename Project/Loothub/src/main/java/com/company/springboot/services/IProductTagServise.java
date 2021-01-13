package com.company.springboot.services;

import com.company.springboot.entities.ProductTag;
import java.util.List;


public interface IProductTagServise {
    public List<ProductTag> listAll();
    public ProductTag save(ProductTag productTag);
    public ProductTag get(Long id);
    public void delete(Long id);
    public void update(ProductTag productTag);
}
