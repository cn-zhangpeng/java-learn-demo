package com.java.learn.redis.stream.demo;

import org.junit.jupiter.api.Test;
import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.stream.StreamAddArgs;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = {DemoApplication.class})
public class RedisStreamTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void producer() {

        RStream<String, String> rStream = redissonClient.getStream("email");

        for (int i = 0; i < 1000; i ++) {
            Map<String, String> email = new HashMap<>();
            email.put("email", "test" + i + "@com.cn");

            StreamAddArgs<String, String> streamAddArgs = StreamAddArgs.entries(email);
            rStream.add(streamAddArgs);
        }

    }

}
