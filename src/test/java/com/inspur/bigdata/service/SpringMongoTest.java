/**
 * @(#)SpringMongoTest.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.service;

import com.inspur.bigdata.domain.User;
import com.inspur.bigdata.domain.UserMongoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMongoTest {

    @Autowired
    private UserMongoRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {

        // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "didi", 30));
        userRepository.save(new User(2L, "mama", 40));
        userRepository.save(new User(3L, "kaka", 50));
        Assert.assertEquals(3, userRepository.findAll().size());

//        // 删除一个User，再验证User总数
//        User u = userRepository.findOne(1L);
//        userRepository.delete(u);
//        Assert.assertEquals(2, userRepository.findAll().size());
//
//        // 删除一个User，再验证User总数
//        u = userRepository.findByName("mama");
//        userRepository.delete(u);
//        Assert.assertEquals(1, userRepository.findAll().size());
    }
}
