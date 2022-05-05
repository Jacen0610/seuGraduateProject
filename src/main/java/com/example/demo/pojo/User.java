package com.example.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userid;
    private String name;
    private String company;
    private Integer bid;
    private Integer winbid;
    private Date creat_time;
    private String password;
    private String email;
    private String capacity;

}
