package com.zhh_fu.provider_ticket.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public String getTicket(){
        System.out.println("8001");
        return "青春猪头少年不可能梦到兔女郎学姐 剧场版";
    }
}
