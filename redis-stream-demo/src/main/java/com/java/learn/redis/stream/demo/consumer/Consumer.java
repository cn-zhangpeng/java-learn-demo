package com.java.learn.redis.stream.demo.consumer;

import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.StreamGroup;
import org.redisson.api.StreamMessageId;
import org.redisson.api.stream.StreamReadGroupArgs;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class Consumer {

    @Resource
    private RedissonClient redissonClient;

    @PostConstruct
    public void consume() {
        RStream<String, String> stream = redissonClient.getStream("email");
        List<StreamGroup> streamGroups = stream.listGroups();
        boolean groupNotExist = true;
        for (StreamGroup streamGroup : streamGroups) {
            if (streamGroup.getName().equals("email_data")) {
                groupNotExist = false;
                break;
            }
        }
        if (groupNotExist) {
            stream.createGroup("email_data");
        }

        MyThread myThread1 = new MyThread("consumer-1");
        MyThread myThread2 = new MyThread("consumer-2");

        new Thread(myThread1).start();
        new Thread(myThread2).start();
    }

    class MyThread implements Runnable {

        private final String consumerName;

        public MyThread(String consumerName) {
            this.consumerName = consumerName;
        }

        @Override
        public void run() {
            while (true) {
                RStream<String, String> stream = redissonClient.getStream("email");

                Map<StreamMessageId, Map<String, String>> messages = stream.readGroup("email_data", consumerName, StreamReadGroupArgs.neverDelivered());

                for (Map.Entry<StreamMessageId, Map<String, String>> entry : messages.entrySet()) {
                    StreamMessageId messageId = entry.getKey();
                    Map<String, String> msg = entry.getValue();

                    System.out.println(messageId + " --- " + msg);

                    stream.ack("email_data", messageId);
                    stream.remove(messageId);
                }
            }
        }
    }

}
