package com.atguigu.boot01.controller;

import com.atguigu.boot01.bean.Car;
import com.atguigu.boot01.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@ResponseBody
//@Controller
@Slf4j//注入日志类
@RestController
public class HelloController {
//    @Autowired
//    Car car;
//    @RequestMapping("/car")
//    public Car car(){
//        return car;
//    }
//
//    @RequestMapping("/hello")//映射hello请求
//    public String handle01(@RequestParam("name") String name){
//        log.info("请求进来了。。。");
//        return "hello,Spring Boot 2!"+name;
//    }
//    @Autowired
//    Person person;
//
//    @RequestMapping("/person")
//    public Person person(){
//        String userName = person.getUserName();
//        System.out.println(userName);
//        return person;
//    }
//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String postUser(){
        return "POST-张三";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETEE-张三";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT-张三";
    }
}
