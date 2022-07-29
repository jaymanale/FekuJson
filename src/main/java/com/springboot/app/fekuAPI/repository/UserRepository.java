package com.springboot.app.fekuAPI.repository;

import com.springboot.app.fekuAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
