/**
 * @(#)ProgramInfoConfigTest.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.service;

import com.inspur.bigdata.config.ProgramInfoConfig;
import junit.framework.Assert;
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
public class ProgramInfoConfigTest {

    @Autowired
    private ProgramInfoConfig programInfoConfig;

    @Test
    public void getProgramInfo(){
        Assert.assertEquals(programInfoConfig.getAuthor(), "chenhao");
        Assert.assertEquals(programInfoConfig.getDepartment(), "bigdata");

        System.out.println(programInfoConfig.getDesc());
    }
}
