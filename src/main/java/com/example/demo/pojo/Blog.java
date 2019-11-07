package com.example.demo.pojo;

import lombok.Data;

@Data
public class Blog {
    //标题
    private String title;
    //内容
    private String text;
    //标签
    private String tag;
    //id
    private Integer id;
    //时间
    private String date;
    //添加描述
    private String description;
}
