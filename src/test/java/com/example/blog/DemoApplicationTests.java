package com.example.blog;

import com.example.blog.Service.Test_Service;
import com.example.blog.pojo.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Test_Service test_service;
    @Test
    void contextLoads() {
        List<Blog> user  = test_service.select();
        System.out.println("hello world"+user);
    }
}
