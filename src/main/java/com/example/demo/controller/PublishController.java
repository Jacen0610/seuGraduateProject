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
public class PublishController {
    @Autowired
    InfoService infoService;

    @RequestMapping("/sendPublish")
    public String publishInfo(@RequestParam("Publisher") String Publisher,
                              @RequestParam("companyP") String companyP,
                              @RequestParam("InfoP") String InfoP,
                              @RequestParam("contactP") String contactP,
                              @RequestParam("PriceP") double priceP,
                              Model model){

        Map<String,Object> mapP = new HashMap<>();
        mapP.put("name",Publisher);
        mapP.put("information",InfoP);
        mapP.put("price",priceP);
        mapP.put("contact",contactP);
        mapP.put("infoCompany",companyP);

        infoService.addInfo(mapP);

        return "publishScd";

    }
}
