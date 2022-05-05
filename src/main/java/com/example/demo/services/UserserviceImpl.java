package com.example.demo.services;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserserviceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }


    @Override
    public int addUser(Map<String, Object> map) {
        return userMapper.addUser(map);
    }

    @Override
    public int deleteUser(Map<String, Object> map) {
        return userMapper.deleteUser(map);
    }

    @Override
    public int updateUser(Map<String, Object> map) {
        return userMapper.updateUser(map);
    }
}
