package com.zhh_fu.consumer_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//服务消费者
//@EnableDiscoveryClient 开启发现服务提供者功能
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }

    //发送HTTP请求
    @Bean         //放在容器中
    @LoadBalanced //使用负载均衡机制
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
