package com.java.learn.springboot.unittestdemo.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.java.learn.springboot.unittestdemo.entity.User;
import com.java.learn.springboot.unittestdemo.mapper.UserMapper;
import com.java.learn.springboot.unittestdemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 华夏紫穹
 * @date 2021年06月04日 14:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private Snowflake snowflake;

    @Override
    public Long addUser(User user) {
        user.setId(snowflake.nextId());
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public User getUser(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        return userMapper.deleteById(userId) == 1;
    }

}
