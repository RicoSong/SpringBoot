package com.example.demo.Controller;

import com.example.demo.Service.Test_Service;
import com.example.demo.pojo.Data;
import com.example.demo.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Hander {
    @Autowired
    private Test_Service test_service;
    @RequestMapping("/select")
    public List<Data> select() {
      /*  List<Data> select = test_service.select();
        return null;*/
       return test_service.select();
    }
    @RequestMapping("/insert")
    public String insert(Blog blog,Model model){
        System.out.println(blog.getTitle()+" "+blog.getText()+" "+blog.getTag());
/*        Blog blog = new Blog();
        blog.setTitle("rico");
        blog.setText("welcome to tihs page");
        blog.setTag("java");*/
        test_service.insert(blog);
        System.out.println("hell rico");
        model.addAttribute("blog",blog);
        return "index";
    }
}
