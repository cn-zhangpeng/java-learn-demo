package com.java.learn.springboot.unittestdemo.service;

import com.java.learn.springboot.unittestdemo.entity.User;

/**
 * @author 华夏紫穹
 * @date 2021年06月04日 14:04
 */
public interface UserService {

    /**
     * 添加用户
     * @param user 用户信息
     * @return 用户ID
     */
    Long addUser(User user);

    /**
     * 根据ID查询用户
     * @param userId 用户ID
     * @return 用户详情
     */
    User getUser(Long userId);

    /**
     * 删除用户
     * @param userId 用户ID
     * @return 删除成功，返回true，否则返回false
     */
    Boolean deleteUser(Long userId);

}
