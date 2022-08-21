package com.java.learn.springboot.i18n.controller;

import com.java.learn.springboot.i18n.util.MessageUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/i18n")
public class MessageController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        String code = "error.A1002";
        String message = MessageUtils.get(code);
        Map<String, String> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", message);
        return result;
    }

}
