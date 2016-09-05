/**
 * @(#)JpaUserRepositoryTest.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.domain;

import org.junit.Assert;
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
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test() throws Exception {
        customerRepository.save(new Customer("aaa", "zzz"));
        customerRepository.save(new Customer("bbb", "yyy"));
        customerRepository.save(new Customer("ccc", "xxx"));
        customerRepository.save(new Customer("ddd", "www"));
        customerRepository.save(new Customer("eee", "vvv"));
        customerRepository.save(new Customer("fff", "uuu"));
        customerRepository.save(new Customer("ggg", "ttt"));
        customerRepository.save(new Customer("hhh", "sss"));

        Assert.assertEquals(8, customerRepository.findAll().size());

        Assert.assertEquals("fff", customerRepository.findByLastName("uuu").get(0).getFirstName());

        Assert.assertEquals("aaa@inspur.com", customerRepository.findCustomer("zzz").getEmailAddress());

        customerRepository.delete(customerRepository.findByLastName("zzz"));
        Assert.assertEquals(7, customerRepository.findAll().size());

        customerRepository.deleteByLastName("yyy");
        Assert.assertEquals(6, customerRepository.findAll().size());




    }

}
