package com.example.demo.controller;

import com.example.demo.pojo.Info;
import com.example.demo.pojo.User;
import com.example.demo.services.InfoService;
import com.example.demo.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class CommonController {

    @Autowired
    UserService userService;
    @Autowired
    InfoService infoService;

    @RequestMapping("/userList")
    public Object searchUser(Model model){

        List<User> users = userService.getUserList();
        model.addAttribute("users",users);

        return "userList";

    }

    @RequestMapping("/info")
    public Object searchInfo(Model model){

        List<Info> infos = infoService.getInfoList();
        model.addAttribute("infos",infos);

        return "InfoList";

    }
    @RequestMapping("/userFile")
    public Object userFile(Model model){
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        User cuser = userService.getUserById(currentUser.getUserid());
        model.addAttribute("cuser",cuser);
        return "user";
    }
    @RequestMapping("/toUpdateUser")
    public Object toUserUpdate(Model model){
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        User cuser = userService.getUserById(currentUser.getUserid());
        model.addAttribute("cuser",cuser);
        return "userUpdate";
    }
    @RequestMapping("/publish")
    public Object publishInfo(Model model){
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        model.addAttribute("cuser",currentUser);
        return "publish";
    }





    @RequestMapping("/updateInfo/{id}")
    public Object publishUpdate(@PathVariable("id")Integer id,Model model){

        Info info = infoService.getInfoById(id);
        model.addAttribute("info",info);
        return "publishUpdate";
    }

    @RequestMapping("/deleteInfo/{id}")
    public Object infoDelete(@PathVariable("id")Integer id,Model model){
        Info info = infoService.getInfoById(id);
        model.addAttribute("info",info);
        return "infoDeleteConfirmPage";

    }

    @RequestMapping("/infoDeleteConfirm")
    public Object infoDeleteConfirm(@RequestParam("id")Integer id){

        infoService.deleteInfo(id);
        return "infoDeleteScd";
    }

    @RequestMapping("/updateUser/{id}")
    public Object adminUserUpdate(@PathVariable("id")String id,Model model){

        User user = userService.getUserById(id);
        model.addAttribute("thisUser",user);
        return "adminUserUpdate";
    }
    @RequestMapping("/deleteUser/{id}")
    public Object adminUserDelete(@PathVariable("id")String id,Model model){

        User user = userService.getUserById(id);
        model.addAttribute("thisUser",user);
        return "userDeleteConfirmPage";
    }

    @RequestMapping("/userDeleteConfirm")
    public Object userDeleteConfirm(@RequestParam("userid")String userid){
        Map<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        userService.deleteUser(map);

        return "userDeleteScd";
    }

    @RequestMapping("/info2")
    public Object userInfo(Model model) {

        List<Info> infos = infoService.getInfoList();
        model.addAttribute("infos", infos);

        return "InfoList2";
    }

    @RequestMapping("/joinInfo/{id}")
    public Object joinInfo(@PathVariable("id") Integer id,Model model){

        Info info = infoService.getInfoById(id);

        String status = info.getStatus();
        if (status.equals("On")) {
            Subject subject = SecurityUtils.getSubject();
            User currentUser = (User) subject.getPrincipal();
            model.addAttribute("juser", currentUser);
            model.addAttribute("joinInfo",info);
            return "joinConfirm";
        }
        else{
            return "projectHasStop";
        }
    }
}
