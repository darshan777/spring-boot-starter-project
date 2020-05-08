package com.example.demo.repository;

import com.example.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRRepository extends JpaRepository<User, Integer> {

}
