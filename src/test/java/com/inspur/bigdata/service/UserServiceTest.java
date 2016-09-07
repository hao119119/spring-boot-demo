/**
 * @(#)UserServiceTest.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        // 准备，清空user表
        userService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {
//        // 插入5个用户
//        userService.create("a", 1);
//        userService.create("b", 2);
//        userService.create("c", 3);
//        userService.create("d", 4);
//        userService.create("e", 5);
//
//        // 查数据库，应该有5个用户
//        Assert.assertEquals(5, userService.getAllUsers().intValue());
//
//        // 删除两个用户
//        userService.deleteByName("a");
//        userService.deleteByName("e");
//
//        // 查数据库，应该有5个用户
//        Assert.assertEquals(3, userService.getAllUsers().intValue());

    }
}
