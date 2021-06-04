package com.java.learn.springboot.unittestdemo.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 华夏紫穹
 * @date 2021年06月04日 14:27
 */
@Configuration
public class SnowflakeConfig {

    @Bean
    public Snowflake idWorker() {
        return IdUtil.getSnowflake(1, 1);
    }

}
