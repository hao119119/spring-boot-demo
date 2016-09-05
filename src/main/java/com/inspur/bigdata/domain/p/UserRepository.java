/**
 * @(#)UserRepository.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.domain.p;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
