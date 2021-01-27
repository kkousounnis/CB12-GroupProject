package com.company.springboot.repository;

import com.company.springboot.entities.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAddressRepository extends JpaRepository<UserAddress, Integer>{
    UserAddress findById(int id);
}
