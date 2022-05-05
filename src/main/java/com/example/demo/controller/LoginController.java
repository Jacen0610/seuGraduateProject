package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @RequestMapping("/user/login")
    public  String login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Model model){


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);



        try {

            subject.login(token);



            return "dashboard";
        }catch (UnknownAccountException e){
            model.addAttribute("error","Access Denied. Maybe Wrong Account");
            return "index";

        }catch (IncorrectCredentialsException e){
            model.addAttribute("error","Access Denied. Maybe Wrong Password");
            return "index";
        }


    }
}
