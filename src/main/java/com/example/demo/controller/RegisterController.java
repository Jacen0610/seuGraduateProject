package com.example.demo.controller;

import com.example.demo.services.UserService;
import com.example.demo.utils.idUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping("/sendRegister")
    public String register(@RequestParam("userNickname") String name,
                           @RequestParam("company") String company,
                           @RequestParam("emailAddr") String email,
                           @RequestParam("pwd") String pwd,
                           Model model){

        String Id = idUtils.getId();
        model.addAttribute("Id",Id);

        Map<String,Object> map = new HashMap<>();
        map.put("userid", Id);
        map.put("name",name);
        map.put("company",company);
        map.put("password",pwd);
        map.put("email",email);
        userService.addUser(map);


        return "signUp";

    }
}
