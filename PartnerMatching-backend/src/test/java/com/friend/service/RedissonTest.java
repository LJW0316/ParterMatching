package com.friend.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    void test() {
        RList<String> rlist = redissonClient.getList("test-list");
//        rlist.add("abc");
//        rlist.add("defg");
        System.out.println(rlist.get(0));
        rlist.remove(0);
    }
}
