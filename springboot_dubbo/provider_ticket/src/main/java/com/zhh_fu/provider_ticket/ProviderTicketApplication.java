package com.zhh_fu.provider_ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务提供者注册到注册中心
 *       1、引入dubbo和zkclient相关依赖
 *       2、配合dubbo的扫描包和注册中心
 *       3、使用dubbo的@Service发布服务
 */
@SpringBootApplication
public class ProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApplication.class, args);
    }

}
