package com.zhh_fu.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、连接工厂ConnectionFactory
 * 3、RabbitProperties封装了RabbitMQ的配置
 * 4、RabbitTemplate : 给RabbitMQ发送和接收消息
 * 5、AmqpAdmin ： RabbitMQ系统管理功能组件
 *      创建和删除Queue、Exchange、Binding
 * 6、@EnableRabbit + @RabbitListener 监听指明的队列的内容
 */
@SpringBootApplication
@EnableRabbit //开启基于注解的RabbitMQ
public class AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }

}
