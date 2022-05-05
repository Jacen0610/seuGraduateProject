package com.example.demo.controller;

import com.example.demo.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UpdateInfoController {
    @Autowired
    InfoService infoService;

    @RequestMapping("/updateInfo")
    public String publishInfo(@RequestParam("PublisherU") String publisherU,
                              @RequestParam("companyU") String companyU,
                              @RequestParam("InfoU") String infoU,
                              @RequestParam("contactU") String contactU,
                              @RequestParam("PriceU") double priceU,
                              @RequestParam("StatusU") String statusU,
                              @RequestParam("JoinU") Integer joinU,
                              @RequestParam("id")Integer id,
                              Model model){

        Map<String,Object> mapP = new HashMap<>();
        mapP.put("name",publisherU);
        mapP.put("information",infoU);
        mapP.put("price",priceU);
        mapP.put("contact",contactU);
        mapP.put("infoCompany",companyU);
        mapP.put("status",statusU);
        mapP.put("joinbid",joinU);
        mapP.put("infoid",id);

        infoService.updateInfo(mapP);

        return "updateInfoScd";

    }
}
