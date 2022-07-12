package com.java.learn.springboot.unittestdemo.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @PostConstruct
    public void init() {}
}
