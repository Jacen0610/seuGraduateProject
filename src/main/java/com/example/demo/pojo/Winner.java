package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Winner {

    private Integer winnerid;
    private String winnerAccount;
    private Integer infoid;
    private double price;
}
