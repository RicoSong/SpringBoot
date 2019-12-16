package com.example.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("success")
@Controller
public class ResponseHandler {
    @RequestMapping("/welcome")
    public String test(){
        return "success";
    }
}
