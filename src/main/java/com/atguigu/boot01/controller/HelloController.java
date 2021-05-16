package com.atguigu.boot01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
public class HelloController {


    @RequestMapping("/hello")//映射hello请求
    public String handle01(){
        return "hello,Spring Boot 2!";
    }
}
