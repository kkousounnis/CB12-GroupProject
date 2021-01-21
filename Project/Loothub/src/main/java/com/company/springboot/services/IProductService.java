package com.company.springboot.services;

import com.company.springboot.entities.Product;
import com.company.springboot.entities.dto.ProductDto;
import java.util.List;

public interface IProductService {

    public List<Product> listAll();

    public Product save(ProductDto productDto);

    public Product get(Integer id);

    public void delete(Long id);
}
