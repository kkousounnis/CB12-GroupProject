package com.company.springboot.repository;

import com.company.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByResetPasswordToken(String token);
}
