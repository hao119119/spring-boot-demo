/**
 * @(#)UserServiceImpl.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.service;

import com.inspur.bigdata.domain.User;
import com.inspur.bigdata.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("defaultJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);

    }

    @Override
    public void create(User user) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", user.getName(), user.getAge());

    }

    @Override
    public User getUserById(Long id) {
        return (User) jdbcTemplate.queryForObject("select * from USER where id = "+id+"", new UserMapper());
    }

    @Override
    public User getUserByName(String name) {
        return (User) jdbcTemplate.queryForObject("select * from USER where name = '"+name+"'", new UserMapper());
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from USER where ID = ?", id);
    }

    @Override
    public Integer getUsersCount() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public List<User> getAllUsers(){
        List rows = jdbcTemplate.queryForList("SELECT * FROM USER");
        Iterator it = rows.iterator();
        List<User> users = new ArrayList<>();
        while(it.hasNext()) {
            Map userMap = (Map) it.next();
            Long id = (Long) userMap.get("id");
            String name = (String) userMap.get("name");
            int age = (int) userMap.get("age");
            User user = new User(id, name, age);
            user.setId(id);
            users.add(user);

        }
        return users;

    }



    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
