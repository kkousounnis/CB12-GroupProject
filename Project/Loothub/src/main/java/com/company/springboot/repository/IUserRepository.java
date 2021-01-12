package com.company.springboot.repository;

import com.company.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

//    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
//    User findByEmailAddress(String email);

}
