package com.example.painting.repository;

import com.example.painting.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

