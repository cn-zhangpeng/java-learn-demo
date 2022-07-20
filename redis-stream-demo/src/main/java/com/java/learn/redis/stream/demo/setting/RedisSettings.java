package com.java.learn.redis.stream.demo.setting;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Redis 相关配置
 * @author 山海紫穹
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.redisson")
@Data
public class RedisSettings {

    private int database;

    private String address;

    private String password;

    private int connectTimeout;

    private int idleConnectionTimeout;

    private int timeout;

    private int connectionMinimumIdleSize;

    private int connectionPoolSize;

    private int retryAttempts;

    private int retryInterval;

    private int subscriptionsPerConnection;

    private int scanInterval;

    private String clientName;

}