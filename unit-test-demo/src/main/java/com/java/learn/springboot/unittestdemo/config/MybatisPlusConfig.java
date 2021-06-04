package com.java.learn.springboot.unittestdemo.config;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author 华夏紫穹
 * @date 2021年06月04日 14:34
 */
@Configuration
public class MybatisPlusConfig {

    @Resource
    private ApplicationContext applicationContext;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        if (ArrayUtil.contains(activeProfiles, "test")) {
            // 单元测试，使用 h2 数据库，防止 mysql 中存在垃圾数据
            interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        } else {
            interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        }
        return interceptor;
    }

}
