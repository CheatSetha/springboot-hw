package com.example.hwsb.service.impl;

import com.example.hwsb.model.User;
import com.example.hwsb.repository.UserMapper;
import com.example.hwsb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    @Override
    public List<User> findAllUsers() {
        List<User> users = userMapper.findAllusers();
        return users;
    }

    @Override
    public User findById(String  id) {
        return userMapper.findById(id);
    }
}
