package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Join {

    private Integer jid;
    private Integer infoNo;
    private String account;
    private String userInc;
    private Integer userBid;
    private Integer userWin;
    private double score;
    private double offerPrice;
    private String status;
}
