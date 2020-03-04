package com.zhh_fu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    /**
     * second,minute,hour,day of month,month,day of week
     * 使用cron
     * * * * * * Sun(或者Mon)上面的每一个*都对应着一个内容,中间使用空格分离
     * 如 0 20 3 1 3 Sun 代表如果是3月1日周日的3时20分0秒启动
     */
    @Scheduled(cron = "40-44 * * * * Sun")
    public void sayHello(){
        System.out.println("hello nihao");
    }
}
