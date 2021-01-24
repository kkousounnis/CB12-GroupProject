package com.company.springboot.services;

import com.company.springboot.dao.OrdersDao;
import com.company.springboot.entities.Orders;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class OrdersService implements IOrdersServices {
    
    @Autowired
    private OrdersDao ordersDao; 
            
    @Override
    public List<Orders> listAll() {
        return ordersDao.listAll();
    }

    @Override
    public Orders save(Orders orders) {
        return ordersDao.save(orders); 
    }

    @Override
    public Orders get(Long id) {
        return ordersDao.get(id); 
    }

    @Override
    public void delete(Long id) {
        try {
        ordersDao.delete(id);
        } catch (EntityNotFoundException e) {
           System.out.println("Role Servises didnt find id to delete");
        }
    }

    @Override
    public void update(Orders orders) {
        ordersDao.update(orders);
    }
    
}
