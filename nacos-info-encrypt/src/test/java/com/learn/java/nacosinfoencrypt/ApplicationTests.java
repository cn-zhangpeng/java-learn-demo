package com.learn.java.nacosinfoencrypt;

import com.learn.java.nacosinfoencrypt.common.util.RedisUtil;
import com.learn.java.nacosinfoencrypt.entity.Test1;
import com.learn.java.nacosinfoencrypt.mapper.Test1Mapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class ApplicationTests {

    @Resource
    private Test1Mapper test1Mapper;

    @Resource
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {

        // 数据库测试
        List<Test1> data = test1Mapper.selectList(null);
        log.info("database test, data: {}", data);

        // redis测试
        redisUtil.set("redis-key", "redis-test-data", 1, TimeUnit.MINUTES);
        String data2 = (String) redisUtil.get("redis-key");
        log.info("redis test, data: {}", data2);

    }

}
