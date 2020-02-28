package com.zhh_fu.amqp;

import com.zhh_fu.amqp.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    //创建交换机，可以指定多种属性
    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpmin.exchange"));
        System.out.println("创建交换器完成");
    }

    //创建队列
    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("amqpmin.queue", true));
        System.out.println("创建队列完成");
    }

    //创建绑定规则
    @Test
    public void createBinding(){
        amqpAdmin.declareBinding(new Binding("amqpmin.queue", Binding.DestinationType.QUEUE,
                "amqpmin.exchange", "amqp.hahaha", null));
        System.out.println("创建绑定完成");
    }

    /**
     * 1、点对点，单播
     */
    @Test
    void contextLoads() {
        //message 需要自己构造一个，定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);

        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是一次测试");
        map.put("data", Arrays.asList("fuzhihang",897,false));

        //只需要传入要发送的对象，自动序列化发送给RabbitMQ
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("符志航","太牛逼了啊"));
    }

    @Test
    //接受数据
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    //使用fanout进行广播，不用加route-key
    void sendMsg () {
        //只需要传入要发送的对象，自动序列化发送给RabbitMQ
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("娃哈哈","王力宏"));
    }

}
