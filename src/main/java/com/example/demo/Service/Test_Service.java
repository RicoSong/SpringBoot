package com.example.demo.Service;

import com.example.demo.dao.Mapper;
import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test_Service {
    @Autowired
    private Mapper mapper;
    public List<Data> select(){
       return  mapper.select();
    }

    public void insert(Blog blog) {
        mapper.insert(blog);
    }
}
