package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("success")
@Controller
public class ResponseHandler {
    @RequestMapping("/welcome")
    public String test(){
        System.out.println("success");
        return "success";
    }
}
