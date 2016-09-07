/**
 * @(#)UserService.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.service;

import com.inspur.bigdata.domain.User;

import java.util.List;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
public interface UserService {

    /**
     * 新增用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    void create(User user);

    User getUserById(Long id);

    User getUserByName(String name);

    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);

    void deleteById(Long id);

    /**
     * 获取用户总量
     */
    List<User> getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    public Integer getUsersCount();
}
