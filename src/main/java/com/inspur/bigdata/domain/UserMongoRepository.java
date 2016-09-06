/**
 * @(#)UserRepository.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
public interface UserMongoRepository extends MongoRepository<User, Long> {

    User findByName(String name);
}
