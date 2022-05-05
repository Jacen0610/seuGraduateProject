package com.example.demo.controller;

import com.example.demo.mapper.WinnerMapper;
import com.example.demo.pojo.Info;
import com.example.demo.pojo.Join;
import com.example.demo.pojo.User;
import com.example.demo.services.InfoService;
import com.example.demo.services.JoinService;
import com.example.demo.services.UserService;
import com.example.demo.services.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StopController {

    @Autowired
    JoinService joinService;
    @Autowired
    InfoService infoService;
    @Autowired
    UserService userService;
    @Autowired
    WinnerService winnerService;


    @RequestMapping("/stopInfo/{id}")
    public Object stopInfo(@PathVariable("id")Integer id, Model model){

        Info info = infoService.getInfoById(id);
        List<Join> joinList = joinService.getJoinListByInfoNo(id);
        if (info.getStatus().equals("On")) {

            model.addAttribute("totalMember",joinList);
            model.addAttribute("chosenInfo",info);

        return "stopConfirm";
        }
        else{
            return "projectHasStop";
        }
    }

    @RequestMapping("/stopScd")
    public Object stopScd(@RequestParam("stopInfoId")Integer id, Model model){

        Join join = joinService.getTheHighestScore(id);
        model.addAttribute("winner",join);

        String uid = join.getAccount();
        User winner = userService.getUserById(uid);
        Map<String,Object> umap = new HashMap<>();
        umap.put("userid",uid);
        umap.put("winbid",winner.getWinbid()+1);
        userService.updateUser(umap);

        Map<String,Object> map = new HashMap<>();
        map.put("status","off");
        map.put("infoid",id);
        infoService.updateInfo(map);

        Info info = infoService.getInfoById(id);
        model.addAttribute("lockInfo",info);

        Map<String,Object> wmap = new HashMap<>();
        wmap.put("winnerAccount",uid);
        wmap.put("infoid",id);
        wmap.put("price",join.getOfferPrice());
        winnerService.winInsert(wmap);
        return "winnerPage";
    }
}
