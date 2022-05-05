package com.example.demo;


import com.example.demo.pojo.Join;
import com.example.demo.services.InfoService;
import com.example.demo.services.JoinServiceImpl;
import com.example.demo.services.UserserviceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    JoinServiceImpl joinService;
    @Test
    public void test2(){


    }


}
