package com.example.demo.Controller;

import com.example.demo.Service.Test_Service;
import com.example.demo.pojo.Blog;
import com.example.demo.utils.limitCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Hander {
    @Autowired
    private Test_Service test_service;
    @Value("${pageNumber}")
    private int pageNumber;   //每页显示的 数据个数
    private limitCode limit = new limitCode();
    @RequestMapping("/")
    public String select_limit(@RequestParam(value = "page",defaultValue = "1") String page, Model model ) {

       // System.out.println("page="+page);
        //获取总页数
        int total = test_service.count();
      //设置默认参数，首次访问
        int firstPage=Integer.parseInt(page);
        //判断接受的page 是否为空
     /*   if(page!=0){
            firstPage=page;
        }*/
       // int thispage=(firstPage+1)*pageNumber;
        System.out.println(firstPage+" "+pageNumber);

        List<Blog> blogs = test_service.limit_blog(firstPage,pageNumber);
        limit.setPage(firstPage);

        limit.setTotal(total);
        limit.setBlogs(blogs);
        model.addAttribute("limit",limit);
        System.out.println(blogs);
        return "index";
    }

    @RequestMapping("/index")
    public String select(Model model) {
      /*  List<Data> select = test_service.select();
        return null;*/
        List<Blog> blogs = test_service.select();
        model.addAttribute("blogs",blogs);
        System.out.println(blogs);
        return "index";
    }
    @RequestMapping("/insert")
    public String insert(Blog blog,Model model){
        System.out.println(blog.getTitle()+" "+blog.getText()+" "+blog.getTag());
/*        Blog blog = new Blog();
        blog.setTitle("rico");
        blog.setText("welcome to tihs page");
        blog.setTag("java");*/
        test_service.insert(blog);
        List<Blog> blogs = test_service.select();
        model.addAttribute("blogs",blogs);
        return "index";
    }
}
