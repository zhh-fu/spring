package com.zhh_fu.consumer_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/buy")
    public String buyTicket(String name){
        //此处url不用写ip地址，直接写应用的提供者名字加路径即可
        String str = restTemplate.getForObject("http://PROVIDERTICKET/ticket", String.class);
        return name + "购买了" + str;
    }
}
