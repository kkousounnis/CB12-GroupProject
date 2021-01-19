package com.company.springboot.dao;

import com.company.springboot.services.*;
import com.company.springboot.entities.ProductImage;
import java.util.List;

public interface IProductImageDao {

    public List<ProductImage> listAll();

    public ProductImage save(ProductImage productImage);

    public ProductImage get(Long id);

    public void delete(Long id);

}
