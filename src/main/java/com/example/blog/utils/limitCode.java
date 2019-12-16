package com.example.blog.utils;

import com.example.blog.pojo.Blog;
import lombok.Data;

import java.util.List;

@Data
public class limitCode {
    private int pageNumber;
    private int page;
    private int total;
    private List<Blog> blogs;
    //分页信息
    private List<Integer> list;
}
