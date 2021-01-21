package com.company.springboot.dao;

import com.company.springboot.services.*;
import com.company.springboot.entities.Product;
import com.company.springboot.entities.dto.ProductDto;
import java.util.List;

public interface IProductDao {

    public List<Product> listAll();

    public Product save(Product product);

    public Product get(Integer id);

    public void delete(Long id);
}
