package com.example.demo.Controller;

import com.example.demo.Service.PageNmber;
import com.example.demo.Service.Test_Service;
import com.example.demo.pojo.Blog;
import com.example.demo.utils.limitCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Controller
public class Handler {
    @Autowired
    private Test_Service test_service;
    @Value("${pageNumber}")
    private int pageNumber;   //每页显示的 数据个数
    private limitCode limit = new limitCode();
    @RequestMapping("/")
    public String select_limit(@RequestParam(value = "page",defaultValue = "1") String page, Model model ) {
        //获取总页数
        int total = test_service.count();
      //获取当前page
        int firstPage=Integer.parseInt(page);

        //返回分页需要的page
        PageNmber pagenumber = new PageNmber();
        List<Integer> thispage = pagenumber.page(firstPage,total);
        List<Blog> blogs = test_service.limit_blog(firstPage,pageNumber);
        //更新limit
        limit.setPage(firstPage);
        limit.setTotal(total);
        limit.setBlogs(blogs);
        limit.setList(thispage);
        model.addAttribute("limit",limit);
        return "index";
    }
    //get请求可能导致数据超出限制长度
    @PostMapping("/insert")
    public String insert(Blog blog,Model model){
        Date date  = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(date);
        blog.setDate(s);
        test_service.insert(blog);
        int total = test_service.count();
        //插入数据后 默认返回第一页
        List<Blog> blogs = test_service.limit_blog(1,pageNumber);
        limit.setBlogs(blogs);
        limit.setTotal(total);
        limit.setPage(1);
        model.addAttribute("limit",limit);
        return "redirect:/";
    }
}
