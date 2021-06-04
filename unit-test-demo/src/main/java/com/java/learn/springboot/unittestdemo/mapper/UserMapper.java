package com.java.learn.springboot.unittestdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.learn.springboot.unittestdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 华夏紫穹
 * @date 2021年06月04日 14:03
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
