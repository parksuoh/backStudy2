package com.boardtest.demo.repositories;

import com.boardtest.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);

    User findByName(String name);

}
