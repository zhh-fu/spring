package com.zhh_fu.consumer_user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhh_fu.provider_ticket.service.TicketService;
import org.springframework.stereotype.Service;

@Service //注意是Spring的Service
public class UserService {

    @Reference  //远程引用，全类名匹配，看看谁在注册中心注册，找到了就可以引用
                //dubbo的订阅功能
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("接收成功！" + ticket);
    }
}
