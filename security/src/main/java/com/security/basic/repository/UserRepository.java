package com.security.basic.repository;

import com.security.basic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // findBy 규칙 username 문법
    User findByUsername(String username);
}
