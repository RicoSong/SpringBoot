package com.example.demo.Controller;

import com.example.demo.Service.Test_Service;
import com.example.demo.pojo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
public class Hander {
    @Autowired
    private Test_Service test_service;

    @RequestMapping("/select")
    public List<Data> select() {
      /*  List<Data> select = test_service.select();
        return null;*/
       return test_service.select();
    }
}
