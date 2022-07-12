package com.learn.java.nacosinfoencrypt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test1")
public class Test1 {

    @TableId("col1")
    private Integer col1;

    private String col2;

    private String col3;

}
