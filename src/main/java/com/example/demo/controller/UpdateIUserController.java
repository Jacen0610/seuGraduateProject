package com.example.demo.controller;

import com.example.demo.services.InfoService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UpdateIUserController {
    @Autowired
    UserService userService;

    @RequestMapping("/updateUser")
    public String publishInfo(@RequestParam("CompanyU") String CompanyU,
                              @RequestParam("NameU") String NameU,
                              @RequestParam("EmailU") String EmailU,
                              @RequestParam("PasswordU") String PasswordU,
                              @RequestParam("Account") String Account,
                              Model model){

        Map<String,Object> mapU = new HashMap<>();
        mapU.put("company",CompanyU);
        mapU.put("name",NameU);
        mapU.put("email",EmailU);
        mapU.put("password",PasswordU);
        mapU.put("userid",Account);

        userService.updateUser(mapU);



        return "updateUserScd";

    }
}
