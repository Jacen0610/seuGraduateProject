package com.example.demo.controller;

import com.example.demo.mapper.JoinMapper;
import com.example.demo.pojo.Info;
import com.example.demo.pojo.Join;
import com.example.demo.pojo.User;
import com.example.demo.services.InfoService;
import com.example.demo.services.JoinService;
import com.example.demo.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExpertController {
    @Autowired
    JoinService joinService;
    @Autowired
    InfoService infoService;
    @Autowired
    UserService userService;

    @RequestMapping("/expert")
    public String expertHomepage(Model model){

        List<Join> joinList = joinService.getJoinList();
        model.addAttribute("joinList",joinList);
        return "expert";
    }
    @RequestMapping("/searchJoinList")
    public String searchJoinList(@RequestParam("InfoIdJ")Integer id,Model model){

        List<Join> joinList = joinService.getJoinListByInfoNo(id);
        model.addAttribute("sjoinlist",joinList);
        return "expertSearchScd";
    }

    @RequestMapping("/score/{id}")
    public Object joinInfo(@PathVariable("id") Integer id, Model model){

        Join join = joinService.getJoinListByJid(id);
        Info info = infoService.getInfoById(join.getInfoNo());
        User user = userService.getUserById(join.getAccount());
        if (info.getStatus().equals("On") && join.getStatus().equals("UnScore")){

        model.addAttribute("scoreInfo",info);
        model.addAttribute("scoreUser",user);
        model.addAttribute("join",join);

        return "scoreConfirm";
        }
        else{
            return "scored";
        }
    }
    @RequestMapping("/scoreHasDone")
    public Object scoreHasDone(@RequestParam("score")double score,
                               @RequestParam("joinIdS")Integer id,
                               @RequestParam("Pid")Integer pid,
                               Model model){


        Map<String,Object> map = new HashMap<>();
        map.put("jid",id);
        map.put("score",score);
        map.put("status","Scored");
        joinService.updateJoin(map);
        model.addAttribute("pid",pid);
        return "expertScd";
    }
}
