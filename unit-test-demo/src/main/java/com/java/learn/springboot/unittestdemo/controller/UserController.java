package com.java.learn.springboot.unittestdemo.controller;

import com.java.learn.springboot.unittestdemo.entity.User;
import com.java.learn.springboot.unittestdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 华夏紫穹
 * @date 2021年06月04日 13:58
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/addUser")
    public Long addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/deleteUser")
    public Boolean deleteUser(@RequestParam Long userId) {
        return userService.deleteUser(userId);
    }

}
