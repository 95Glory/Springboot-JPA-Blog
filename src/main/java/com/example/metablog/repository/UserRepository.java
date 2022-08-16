package com.example.metablog.repository;

import com.example.metablog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

}
// JPA Naming 쿼리 전략
// User findByUsernameAndPassword(String username, String password);