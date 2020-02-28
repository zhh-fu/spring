package com.zhh_fu.amqp.service;

import com.zhh_fu.amqp.model.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    //atguigu.news该队列中只要有消息进入就执行下面的方法
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息" + book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive1(Message message){
        System.out.println("收到消息头" + message.getBody());
        System.out.println("收到消息属性" + message.getMessageProperties());
    }
}
