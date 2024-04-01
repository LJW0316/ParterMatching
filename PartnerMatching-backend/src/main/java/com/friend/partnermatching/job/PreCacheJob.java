package com.friend.partnermatching.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.friend.partnermatching.model.domain.User;
import com.friend.partnermatching.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存预热任务
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    //重点用户
    List<Long> mainUserList = Arrays.asList(1L, 2L, 3L);

    //每天执行，加载预热用户
    @Scheduled(cron = "23 48 23 * * *")
    public void doCacheRecommendUser() {
        RLock lock = redissonClient.getLock("friend:precachejob:docache:lock");
        try {
            if (lock.tryLock(0, -1, TimeUnit.MILLISECONDS)) { //等待时间为0，等不到就走
                for (Long userId : mainUserList) {
                    log.info("getLock" + Thread.currentThread().getId());
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 10), queryWrapper);
                    String redisKey = String.format("friend:user:recommend:%s", userId);
                    try {
                        redisTemplate.opsForValue().set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
            }
        } catch (InterruptedException e) {
            log.error("redis set key error", e);
        } finally {
            //只能释放自己的锁
            if (lock.isHeldByCurrentThread()) {
                log.info("unlock" + Thread.currentThread().getId());
                lock.unlock();
            }
        }
    }
}
