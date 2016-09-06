/**
 * @(#)SpringRedisTest.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.service;

import com.inspur.bigdata.domain.RedisUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisTest {

    // run this test must start redis first
    // redis-server &

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, RedisUser> redisTemplate;

    @Test
    public void test() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        // 保存对象
        RedisUser user = new RedisUser("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new RedisUser("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new RedisUser("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

    }

}
