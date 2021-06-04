package com.java.learn.springboot.unittestdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 华夏紫穹
 * @date 2021年06月04日 13:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("user")
public class User {

    private Long id;

    private String username;

    private String sex;

    private Integer age;

}
