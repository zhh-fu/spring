package com.zhh_fu.provider_ticket.controller;

import com.zhh_fu.provider_ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("ticket")
    public String getTicket(){
        return ticketService.getTicket();
    }
}
