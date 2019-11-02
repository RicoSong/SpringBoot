package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/")
    public String FristPage(){
        System.out.println("Hello SpringBoot");
        return "index.html";
    }
}
