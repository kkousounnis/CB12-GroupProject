package com.company.springboot.services;

import com.company.springboot.entities.Orders;
import java.util.List;


public interface IOrdersServises {
    public List<Orders> listAll();
    public Orders save(Orders orders);
    public Orders get(Long id);
    public void delete(Long id);
    public void update(Orders orders);
    
}
