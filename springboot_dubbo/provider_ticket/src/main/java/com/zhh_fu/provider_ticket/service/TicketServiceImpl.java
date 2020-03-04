package com.zhh_fu.provider_ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component //纳入Spring Ioc
@Service //注意是dubbo的service，将服务发布出去
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "千与千寻";
    }
}
