package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.services.UserserviceImpl;
import com.example.demo.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

public class test {


    @Test
    public void batis(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        sqlSession.commit();

        sqlSession.close();
    }
}
