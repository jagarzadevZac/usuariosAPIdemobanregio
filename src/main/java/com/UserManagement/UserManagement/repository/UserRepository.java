package com.UserManagement.UserManagement.repository;

import java.util.Optional;

import com.UserManagement.UserManagement.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{
    Optional<User> findByFirstName(String FirstName);
    boolean existsByfirstName(String firtsName);
}
