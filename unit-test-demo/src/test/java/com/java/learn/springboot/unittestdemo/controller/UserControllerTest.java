package com.java.learn.springboot.unittestdemo.controller;

import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.learn.springboot.unittestdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author 华夏紫穹
 * @date 2021年06月04日 14:14
 */
@SpringBootTest
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
@Slf4j
public class UserControllerTest {

    @Resource
    private MockMvc mockMvc;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testAddUser() throws Exception {
        log.info("start test add user ...");
        User user = createUser();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        log.info("userId: {}", content);
        log.info("test add user end ...");
    }

    @Test
    public void testGetUser() throws Exception {
        log.info("start test get user ...");
        User user = createUser();
        MvcResult addResult = mockMvc.perform(MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String userId = addResult.getResponse().getContentAsString();
        log.info("userId: {}", userId);
        if (ObjectUtils.isEmpty(userId)) {
            return;
        }

        MvcResult getResult = mockMvc.perform(MockMvcRequestBuilders.get("/getUser")
                .param("userId", userId)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String content = getResult.getResponse().getContentAsString();
        log.info("user: {}", content);
        log.info("test get user end ...");
    }

    @Test
    public void testDeleteUser() throws Exception {
        log.info("start test delete user ...");
        User user = createUser();
        MvcResult addResult = mockMvc.perform(MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String userId = addResult.getResponse().getContentAsString();
        log.info("userId: " + userId);

        MvcResult deleteResult = mockMvc.perform(MockMvcRequestBuilders.get("/deleteUser")
                .param("userId", userId)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String content = deleteResult.getResponse().getContentAsString();
        log.info("delete result: {}", content);
        log.info("test delete user end ...");
    }

    private User createUser() {
        return User.builder()
                .username(Arrays.asList("zhangsan", "lisi", "wangwu").get(RandomUtil.randomInt(0, 3)))
                .age(RandomUtil.randomInt(10, 20))
                .sex(Arrays.asList("male", "female").get(RandomUtil.randomInt(0, 2)))
                .build();
    }

}
