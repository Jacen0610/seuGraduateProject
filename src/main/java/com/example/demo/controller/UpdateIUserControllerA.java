package com.example.demo.controller;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UpdateIUserControllerA {
    @Autowired
    UserService userService;

    @RequestMapping("/updateUserA")
    public String publishInfo(@RequestParam("CompanyA") String CompanyA,
                              @RequestParam("NameA") String NameA,
                              @RequestParam("EmailA") String EmailA,
                              @RequestParam("PasswordA") String PasswordA,
                              @RequestParam("AccountA") String AccountA,
                              @RequestParam("AuthorityA") String AuthorityA,
                              Model model){

        Map<String,Object> mapU = new HashMap<>();
        mapU.put("company",CompanyA);
        mapU.put("name",NameA);
        mapU.put("email",EmailA);
        mapU.put("password",PasswordA);
        mapU.put("userid",AccountA);
        mapU.put("capacity",AuthorityA);

        userService.updateUser(mapU);



        return "updateUserScd";

    }
}
