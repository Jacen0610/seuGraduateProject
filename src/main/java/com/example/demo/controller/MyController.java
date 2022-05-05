package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Winner;
import com.example.demo.services.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    WinnerService winnerService;

    @RequestMapping({"/","/index.html","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/dashboard")
    public String main(Model model){

        List<Winner> winnerList = winnerService.winnerList();
        model.addAttribute("deal",winnerList);
        return "dashboard";
    }



    @RequestMapping({"/register","/register.html"})
    public String register(){
        return "register";
    }

    @RequestMapping("/user")
    public String userHomepage(){
        return "user";
    }


    }


