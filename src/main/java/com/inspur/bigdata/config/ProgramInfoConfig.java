/**
 * @(#)ProgramInfoConfig.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
@Component
public class ProgramInfoConfig {

    @Value("${com.inspur.bigdata.author}")
    private String author;

    @Value("${com.inspur.bigdata.department}")
    private String department;

    @Value("${com.inspur.bigdata.desc}")
    private String desc;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
