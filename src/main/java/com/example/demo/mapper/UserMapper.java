package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserMapper {
    List<User> getUserList();
    User getUserById(String id);

    int addUser(Map<String,Object> map);

    int deleteUser(Map<String,Object> map);


    int updateUser(Map<String,Object> map);
}
