package com.example.hwsb.service;

import com.example.hwsb.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> findAllUsers();
    User findById(String id);


}
