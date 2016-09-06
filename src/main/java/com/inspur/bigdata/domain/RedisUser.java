/**
 * @(#)RedisUser.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.domain;

import java.io.Serializable;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
public class RedisUser implements Serializable {

    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public RedisUser(String username, Integer age) {
        this.username = username;
        this.age = age;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
