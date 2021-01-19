package com.company.springboot.services;

import com.company.springboot.entities.ProductImage;
import java.util.List;

public interface IProductImageService {

    public List<ProductImage> listAll();

    public ProductImage save(ProductImage productImage);

    public ProductImage get(Long id);

    public void delete(Long id);

}
