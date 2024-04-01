package com.friend.service;
import java.util.Date;

import com.friend.partnermatching.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testInsert() {
        User user = new User();
        user.setId(0L);
        user.setUsername("aaa");
        user.setUserAccount("");
        user.setAvatarUrl("");
        user.setGender(0);
        user.setProfile("阿巴阿巴");
        user.setUserPassword("");
        user.setPhone("");
        user.setEmail("");
        user.setTags("");
        user.setUserStatus(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDelete(0);
        user.setUserRole(0);
        redisTemplate.opsForValue().set("user", user) ;
    }
}
