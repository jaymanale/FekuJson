package com.springboot.app.fekuAPI.repository;

import com.springboot.app.fekuAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {
}
