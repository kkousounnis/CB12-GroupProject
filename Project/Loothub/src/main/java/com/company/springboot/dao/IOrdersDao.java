package com.company.springboot.dao;

import com.company.springboot.entities.Orders;
import java.util.List;


public interface IOrdersDao {
    public List<Orders> listAll();
    public Orders save(Orders orders);
    public Orders get(Long id);
    public void delete(Long id);
    public void update(Orders orders);
    public Orders findByUserId(Integer userId);
}
