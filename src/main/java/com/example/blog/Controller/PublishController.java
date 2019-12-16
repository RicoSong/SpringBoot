package com.example.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PublishController {
        @RequestMapping("/publish")
        public String publish(@RequestParam(value = "rico",defaultValue = "kiel") String rico){
            return "publish";
        }
}
