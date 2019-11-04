package com.example.demo.Controller;

import com.example.demo.Service.Test_Service;
import com.example.demo.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailsController {
    @Autowired
    Test_Service test_service;
    @RequestMapping("/details")
    public String Details(@RequestParam(value = "id") String Id, Model model){
        //查找相应id的 blog 内容
        int id = Integer.parseInt(Id);
        Blog blog = test_service.findbyId(id);
        model.addAttribute("blog",blog);
        //测试数据
        System.out.println(id);
        System.out.println(blog.getTitle());
        System.out.println(blog.getTag());
        System.out.println(blog.getText());
        return "Details_page";
    }
}
