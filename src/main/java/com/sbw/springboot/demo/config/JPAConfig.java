package com.sbw.springboot.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by sbw on 2017/11/30.
 */
@Configuration
@EnableJpaRepositories("com.sbw.springboot.demo.jpa")
@EntityScan("com.sbw.springboot.demo.jpa.entity")
public class JPAConfig {}
