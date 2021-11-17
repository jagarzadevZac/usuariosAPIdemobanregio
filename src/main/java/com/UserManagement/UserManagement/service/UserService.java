package com.UserManagement.UserManagement.service;

import java.util.List;
import java.util.Optional;

import com.UserManagement.UserManagement.entity.User;
import com.UserManagement.UserManagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {


    @Autowired
    UserRepository userRepository;

    public List<User> list(){
        return userRepository.findAll();
    }

    public Optional<User> getOne(int id){
        return userRepository.findById(id);
    }

    public Optional<User> getByfirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }


    public void save(User user){
        userRepository.save(user);
    }


    public void delete(int id){
        userRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return userRepository.existsById(id);
    }

    public boolean existsByfirstName(String firstName){
        return userRepository.existsByfirstName(firstName);
    }
    
}
