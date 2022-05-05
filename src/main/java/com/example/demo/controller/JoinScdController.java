package com.example.demo.controller;

import com.example.demo.pojo.Info;
import com.example.demo.pojo.User;
import com.example.demo.services.InfoService;
import com.example.demo.services.JoinService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JoinScdController {
    @Autowired
    UserService userService;
    @Autowired
    InfoService infoService;
    @Autowired
    JoinService joinService;

    @RequestMapping("/joinHasConfirmed")
    public String join(@RequestParam("InfoId")Integer infoId,
                       @RequestParam("juserId")String account,
                       @RequestParam("willingPrice")double price){

        Info infoJ = infoService.getInfoById(infoId);
        User userJ = userService.getUserById(account);


        Map<String,Object> mapIJ = new HashMap<>();
        mapIJ.put("joinbid",infoJ.getJoinbid()+1);
        mapIJ.put("infoid",infoId);
        infoService.updateInfo(mapIJ);




        Map<String,Object> mapUJ = new HashMap<>();
        mapUJ.put("bid",userJ.getBid()+1);
        mapUJ.put("userid",account);
        userService.updateUser(mapUJ);

        Map<String,Object> mapJ = new HashMap<>();
        mapJ.put("infoNo",infoJ.getInfoid());
        mapJ.put("account",userJ.getUserid());
        mapJ.put("userInc",userJ.getCompany());
        mapJ.put("userBid",userJ.getBid()+1);
        mapJ.put("userWin",userJ.getWinbid());
        mapJ.put("offerPrice",price);
        joinService.joinInsert(mapJ);









        return "joinScd";
    }
}
