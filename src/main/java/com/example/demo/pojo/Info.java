package com.example.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {


    private Integer infoid;
    private String name;
    private String information;
    private Integer joinbid;
    private String status;
    private double price;
    private Date publishTime;
    private String contact;
    private String infoCompany;

}


