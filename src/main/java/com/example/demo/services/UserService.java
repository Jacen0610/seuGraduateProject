package com.example.demo.services;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getUserList();
    User getUserById(String id);


    int addUser(Map<String,Object> map);


    int deleteUser(Map<String, Object> map);


    int updateUser(Map<String,Object> map);
}
