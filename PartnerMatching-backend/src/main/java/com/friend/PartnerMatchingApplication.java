package com.friend;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *

 */
@SpringBootApplication
@MapperScan("com.friend.partnermatching.mapper")
@EnableScheduling
public class PartnerMatchingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartnerMatchingApplication.class, args);
    }

}
